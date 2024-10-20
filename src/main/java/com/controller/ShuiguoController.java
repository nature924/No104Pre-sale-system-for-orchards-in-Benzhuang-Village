
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
 * 水果预售
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shuiguo")
public class ShuiguoController {
    private static final Logger logger = LoggerFactory.getLogger(ShuiguoController.class);

    private static final String TABLE_NAME = "shuiguo";

    @Autowired
    private ShuiguoService shuiguoService;


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
    private ShuiguoCollectionService shuiguoCollectionService;//水果收藏
    @Autowired
    private ShuiguoOrderService shuiguoOrderService;//水果预售订单
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
        params.put("shuiguoDeleteStart",1);params.put("shuiguoDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shuiguoService.queryPage(params);

        //字典表数据转换
        List<ShuiguoView> list =(List<ShuiguoView>)page.getList();
        for(ShuiguoView c:list){
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
        ShuiguoEntity shuiguo = shuiguoService.selectById(id);
        if(shuiguo !=null){
            //entity转view
            ShuiguoView view = new ShuiguoView();
            BeanUtils.copyProperties( shuiguo , view );//把实体数据重构到view中
            //级联表 果园
            //级联表
            GuoyuanEntity guoyuan = guoyuanService.selectById(shuiguo.getGuoyuanId());
            if(guoyuan != null){
            BeanUtils.copyProperties( guoyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGuoyuanId(guoyuan.getId());
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
    public R save(@RequestBody ShuiguoEntity shuiguo, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shuiguo:{}",this.getClass().getName(),shuiguo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShuiguoEntity> queryWrapper = new EntityWrapper<ShuiguoEntity>()
            .eq("guoyuan_id", shuiguo.getGuoyuanId())
            .eq("shuiguo_name", shuiguo.getShuiguoName())
            .eq("shuiguo_address", shuiguo.getShuiguoAddress())
            .eq("shuiguo_types", shuiguo.getShuiguoTypes())
            .eq("shuiguo_kucun_number", shuiguo.getShuiguoKucunNumber())
            .eq("shuiguo_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuiguoEntity shuiguoEntity = shuiguoService.selectOne(queryWrapper);
        if(shuiguoEntity==null){
            shuiguo.setShuiguoDelete(1);
            shuiguo.setInsertTime(new Date());
            shuiguo.setCreateTime(new Date());
            shuiguoService.insert(shuiguo);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShuiguoEntity shuiguo, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shuiguo:{}",this.getClass().getName(),shuiguo.toString());
        ShuiguoEntity oldShuiguoEntity = shuiguoService.selectById(shuiguo.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shuiguo.getShuiguoPhoto()) || "null".equals(shuiguo.getShuiguoPhoto())){
                shuiguo.setShuiguoPhoto(null);
        }

            shuiguoService.updateById(shuiguo);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShuiguoEntity> oldShuiguoList =shuiguoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShuiguoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShuiguoEntity shuiguoEntity = new ShuiguoEntity();
            shuiguoEntity.setId(id);
            shuiguoEntity.setShuiguoDelete(2);
            list.add(shuiguoEntity);
        }
        if(list != null && list.size() >0){
            shuiguoService.updateBatchById(list);
        }

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
            List<ShuiguoEntity> shuiguoList = new ArrayList<>();//上传的东西
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
                            ShuiguoEntity shuiguoEntity = new ShuiguoEntity();
//                            shuiguoEntity.setGuoyuanId(Integer.valueOf(data.get(0)));   //水果 要改的
//                            shuiguoEntity.setShuiguoName(data.get(0));                    //水果名称 要改的
//                            shuiguoEntity.setShuiguoUuidNumber(data.get(0));                    //水果编号 要改的
//                            shuiguoEntity.setShuiguoPhoto("");//详情和图片
//                            shuiguoEntity.setShuiguoAddress(data.get(0));                    //水果地点 要改的
//                            shuiguoEntity.setShuiguoNewMoney(data.get(0));                    //预售价 要改的
//                            shuiguoEntity.setShuiguoTypes(Integer.valueOf(data.get(0)));   //水果类型 要改的
//                            shuiguoEntity.setShuiguoKucunNumber(Integer.valueOf(data.get(0)));   //水果库存 要改的
//                            shuiguoEntity.setShuiguoContent("");//详情和图片
//                            shuiguoEntity.setShuiguoDelete(1);//逻辑删除字段
//                            shuiguoEntity.setInsertTime(date);//时间
//                            shuiguoEntity.setCreateTime(date);//时间
                            shuiguoList.add(shuiguoEntity);


                            //把要查询是否重复的字段放入map中
                                //水果编号
                                if(seachFields.containsKey("shuiguoUuidNumber")){
                                    List<String> shuiguoUuidNumber = seachFields.get("shuiguoUuidNumber");
                                    shuiguoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shuiguoUuidNumber = new ArrayList<>();
                                    shuiguoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shuiguoUuidNumber",shuiguoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //水果编号
                        List<ShuiguoEntity> shuiguoEntities_shuiguoUuidNumber = shuiguoService.selectList(new EntityWrapper<ShuiguoEntity>().in("shuiguo_uuid_number", seachFields.get("shuiguoUuidNumber")).eq("shuiguo_delete", 1));
                        if(shuiguoEntities_shuiguoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShuiguoEntity s:shuiguoEntities_shuiguoUuidNumber){
                                repeatFields.add(s.getShuiguoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [水果编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shuiguoService.insertBatch(shuiguoList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ShuiguoView> returnShuiguoViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = shuiguoOrderService.queryPage(params1);
        List<ShuiguoOrderView> orderViewsList =(List<ShuiguoOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ShuiguoOrderView orderView:orderViewsList){
            Integer shuiguoTypes = orderView.getShuiguoTypes();
            if(typeMap.containsKey(shuiguoTypes)){
                typeMap.put(shuiguoTypes,typeMap.get(shuiguoTypes)+1);
            }else{
                typeMap.put(shuiguoTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("shuiguoTypes",type);
            PageUtils pageUtils1 = shuiguoService.queryPage(params2);
            List<ShuiguoView> shuiguoViewList =(List<ShuiguoView>)pageUtils1.getList();
            returnShuiguoViewList.addAll(shuiguoViewList);
            if(returnShuiguoViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = shuiguoService.queryPage(params);
        if(returnShuiguoViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnShuiguoViewList.size();//要添加的数量
            List<ShuiguoView> shuiguoViewList =(List<ShuiguoView>)page.getList();
            for(ShuiguoView shuiguoView:shuiguoViewList){
                Boolean addFlag = true;
                for(ShuiguoView returnShuiguoView:returnShuiguoViewList){
                    if(returnShuiguoView.getId().intValue() ==shuiguoView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnShuiguoViewList.add(shuiguoView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnShuiguoViewList = returnShuiguoViewList.subList(0, limit);
        }

        for(ShuiguoView c:returnShuiguoViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnShuiguoViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shuiguoService.queryPage(params);

        //字典表数据转换
        List<ShuiguoView> list =(List<ShuiguoView>)page.getList();
        for(ShuiguoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShuiguoEntity shuiguo = shuiguoService.selectById(id);
            if(shuiguo !=null){


                //entity转view
                ShuiguoView view = new ShuiguoView();
                BeanUtils.copyProperties( shuiguo , view );//把实体数据重构到view中

                //级联表
                    GuoyuanEntity guoyuan = guoyuanService.selectById(shuiguo.getGuoyuanId());
                if(guoyuan != null){
                    BeanUtils.copyProperties( guoyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGuoyuanId(guoyuan.getId());
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
    public R add(@RequestBody ShuiguoEntity shuiguo, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shuiguo:{}",this.getClass().getName(),shuiguo.toString());
        Wrapper<ShuiguoEntity> queryWrapper = new EntityWrapper<ShuiguoEntity>()
            .eq("guoyuan_id", shuiguo.getGuoyuanId())
            .eq("shuiguo_name", shuiguo.getShuiguoName())
            .eq("shuiguo_uuid_number", shuiguo.getShuiguoUuidNumber())
            .eq("shuiguo_address", shuiguo.getShuiguoAddress())
            .eq("shuiguo_types", shuiguo.getShuiguoTypes())
            .eq("shuiguo_kucun_number", shuiguo.getShuiguoKucunNumber())
            .eq("shuiguo_delete", shuiguo.getShuiguoDelete())
//            .notIn("shuiguo_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuiguoEntity shuiguoEntity = shuiguoService.selectOne(queryWrapper);
        if(shuiguoEntity==null){
            shuiguo.setShuiguoDelete(1);
            shuiguo.setInsertTime(new Date());
            shuiguo.setCreateTime(new Date());
        shuiguoService.insert(shuiguo);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

