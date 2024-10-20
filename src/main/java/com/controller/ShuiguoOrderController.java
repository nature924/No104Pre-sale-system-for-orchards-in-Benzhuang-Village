
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 水果预售订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shuiguoOrder")
public class ShuiguoOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ShuiguoOrderController.class);

    private static final String TABLE_NAME = "shuiguoOrder";

    @Autowired
    private ShuiguoOrderService shuiguoOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private GuoshuService guoshuService;//果树
    @Autowired
    private GuoshuCollectionService guoshuCollectionService;//果树收藏
    @Autowired
    private GuoshuOrderService guoshuOrderService;//果树订单
    @Autowired
    private GuoyuanService guoyuanService;//果园
    @Autowired
    private GuoyuanLiuyanService guoyuanLiuyanService;//果园留言
    @Autowired
    private GuoyuanYuyueService guoyuanYuyueService;//果园预约
    @Autowired
    private NewsService newsService;//水果资讯
    @Autowired
    private ShuiguoService shuiguoService;//水果预售
    @Autowired
    private ShuiguoCollectionService shuiguoCollectionService;//水果收藏
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shuiguoOrderService.queryPage(params);

        //字典表数据转换
        List<ShuiguoOrderView> list =(List<ShuiguoOrderView>)page.getList();
        for(ShuiguoOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShuiguoOrderEntity shuiguoOrder = shuiguoOrderService.selectById(id);
        if(shuiguoOrder !=null){
            //entity转view
            ShuiguoOrderView view = new ShuiguoOrderView();
            BeanUtils.copyProperties( shuiguoOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(shuiguoOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 水果预售
            //级联表
            ShuiguoEntity shuiguo = shuiguoService.selectById(shuiguoOrder.getShuiguoId());
            if(shuiguo != null){
            BeanUtils.copyProperties( shuiguo , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShuiguoId(shuiguo.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shuiguoOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShuiguoOrderEntity shuiguoOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shuiguoOrder:{}",this.getClass().getName(),shuiguoOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shuiguoOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        shuiguoOrder.setCreateTime(new Date());
        shuiguoOrder.setInsertTime(new Date());
        shuiguoOrderService.insert(shuiguoOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShuiguoOrderEntity shuiguoOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shuiguoOrder:{}",this.getClass().getName(),shuiguoOrder.toString());
        ShuiguoOrderEntity oldShuiguoOrderEntity = shuiguoOrderService.selectById(shuiguoOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shuiguoOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            shuiguoOrderService.updateById(shuiguoOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShuiguoOrderEntity> oldShuiguoOrderList =shuiguoOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shuiguoOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShuiguoOrderEntity> shuiguoOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShuiguoOrderEntity shuiguoOrderEntity = new ShuiguoOrderEntity();
//                            shuiguoOrderEntity.setShuiguoOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            shuiguoOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            shuiguoOrderEntity.setShuiguoId(Integer.valueOf(data.get(0)));   //水果 要改的
//                            shuiguoOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shuiguoOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            shuiguoOrderEntity.setShuiguoOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            shuiguoOrderEntity.setGuoyuanOrderCourierName(data.get(0));                    //快递公司 要改的
//                            shuiguoOrderEntity.setGuoyuanOrderCourierNumber(data.get(0));                    //快递单号 要改的
//                            shuiguoOrderEntity.setShuiguoOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            shuiguoOrderEntity.setInsertTime(date);//时间
//                            shuiguoOrderEntity.setCreateTime(date);//时间
                            shuiguoOrderList.add(shuiguoOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("shuiguoOrderUuidNumber")){
                                    List<String> shuiguoOrderUuidNumber = seachFields.get("shuiguoOrderUuidNumber");
                                    shuiguoOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shuiguoOrderUuidNumber = new ArrayList<>();
                                    shuiguoOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shuiguoOrderUuidNumber",shuiguoOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<ShuiguoOrderEntity> shuiguoOrderEntities_shuiguoOrderUuidNumber = shuiguoOrderService.selectList(new EntityWrapper<ShuiguoOrderEntity>().in("shuiguo_order_uuid_number", seachFields.get("shuiguoOrderUuidNumber")));
                        if(shuiguoOrderEntities_shuiguoOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShuiguoOrderEntity s:shuiguoOrderEntities_shuiguoOrderUuidNumber){
                                repeatFields.add(s.getShuiguoOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shuiguoOrderService.insertBatch(shuiguoOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shuiguoOrderService.queryPage(params);

        //字典表数据转换
        List<ShuiguoOrderView> list =(List<ShuiguoOrderView>)page.getList();
        for(ShuiguoOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShuiguoOrderEntity shuiguoOrder = shuiguoOrderService.selectById(id);
            if(shuiguoOrder !=null){


                //entity转view
                ShuiguoOrderView view = new ShuiguoOrderView();
                BeanUtils.copyProperties( shuiguoOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(shuiguoOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    ShuiguoEntity shuiguo = shuiguoService.selectById(shuiguoOrder.getShuiguoId());
                if(shuiguo != null){
                    BeanUtils.copyProperties( shuiguo , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShuiguoId(shuiguo.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shuiguoOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShuiguoOrderEntity shuiguoOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shuiguoOrder:{}",this.getClass().getName(),shuiguoOrder.toString());
            ShuiguoEntity shuiguoEntity = shuiguoService.selectById(shuiguoOrder.getShuiguoId());
            if(shuiguoEntity == null){
                return R.error(511,"查不到该水果预售");
            }
            // Double shuiguoNewMoney = shuiguoEntity.getShuiguoNewMoney();

            if(false){
            }
            else if(shuiguoEntity.getShuiguoNewMoney() == null){
                return R.error(511,"预售价不能为空");
            }
            else if((shuiguoEntity.getShuiguoKucunNumber() -shuiguoOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - shuiguoEntity.getShuiguoNewMoney()*shuiguoOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            shuiguoOrder.setShuiguoOrderTypes(101); //设置订单状态为已支付
            shuiguoOrder.setShuiguoOrderTruePrice(shuiguoEntity.getShuiguoNewMoney()*shuiguoOrder.getBuyNumber()); //设置实付价格
            shuiguoOrder.setYonghuId(userId); //设置订单支付人id
            shuiguoOrder.setShuiguoOrderUuidNumber(String.valueOf(new Date().getTime()));
            shuiguoOrder.setInsertTime(new Date());
            shuiguoOrder.setCreateTime(new Date());
                shuiguoEntity.setShuiguoKucunNumber( shuiguoEntity.getShuiguoKucunNumber() -shuiguoOrder.getBuyNumber());
                shuiguoService.updateById(shuiguoEntity);
                shuiguoOrderService.insert(shuiguoOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            ShuiguoOrderEntity shuiguoOrder = shuiguoOrderService.selectById(id);//当前表service
            Integer buyNumber = shuiguoOrder.getBuyNumber();
            Integer shuiguoId = shuiguoOrder.getShuiguoId();
            if(shuiguoId == null)
                return R.error(511,"查不到该水果预售");
            ShuiguoEntity shuiguoEntity = shuiguoService.selectById(shuiguoId);
            if(shuiguoEntity == null)
                return R.error(511,"查不到该水果预售");
            Double shuiguoNewMoney = shuiguoEntity.getShuiguoNewMoney();
            if(shuiguoNewMoney == null)
                return R.error(511,"水果预售价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = shuiguoEntity.getShuiguoNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额



            shuiguoEntity.setShuiguoKucunNumber(shuiguoEntity.getShuiguoKucunNumber() + buyNumber);


            shuiguoOrder.setShuiguoOrderTypes(102);//设置订单状态为已退款
            shuiguoOrderService.updateById(shuiguoOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            shuiguoService.updateById(shuiguoEntity);//更新订单中水果预售的信息

            return R.ok();
    }

    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ShuiguoOrderEntity  shuiguoOrderEntity = shuiguoOrderService.selectById(id);
        shuiguoOrderEntity.setShuiguoOrderTypes(103);//设置订单状态为已发货
        shuiguoOrderService.updateById( shuiguoOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ShuiguoOrderEntity  shuiguoOrderEntity = shuiguoOrderService.selectById(id);
        shuiguoOrderEntity.setShuiguoOrderTypes(104);//设置订单状态为收货
        shuiguoOrderService.updateById( shuiguoOrderEntity);
        return R.ok();
    }

}

