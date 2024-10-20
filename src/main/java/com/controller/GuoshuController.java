
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
 * 果树
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/guoshu")
public class GuoshuController {
    private static final Logger logger = LoggerFactory.getLogger(GuoshuController.class);

    private static final String TABLE_NAME = "guoshu";

    @Autowired
    private GuoshuService guoshuService;


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
        params.put("guoshuDeleteStart",1);params.put("guoshuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = guoshuService.queryPage(params);

        //字典表数据转换
        List<GuoshuView> list =(List<GuoshuView>)page.getList();
        for(GuoshuView c:list){
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
        GuoshuEntity guoshu = guoshuService.selectById(id);
        if(guoshu !=null){
            //entity转view
            GuoshuView view = new GuoshuView();
            BeanUtils.copyProperties( guoshu , view );//把实体数据重构到view中
            //级联表 果园
            //级联表
            GuoyuanEntity guoyuan = guoyuanService.selectById(guoshu.getGuoyuanId());
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
    public R save(@RequestBody GuoshuEntity guoshu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,guoshu:{}",this.getClass().getName(),guoshu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GuoshuEntity> queryWrapper = new EntityWrapper<GuoshuEntity>()
            .eq("guoyuan_id", guoshu.getGuoyuanId())
            .eq("guoshu_name", guoshu.getGuoshuName())
            .eq("guoshu_address", guoshu.getGuoshuAddress())
            .eq("guoshu_types", guoshu.getGuoshuTypes())
            .eq("guoshu_kucun_number", guoshu.getGuoshuKucunNumber())
            .eq("guoshu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuoshuEntity guoshuEntity = guoshuService.selectOne(queryWrapper);
        if(guoshuEntity==null){
            guoshu.setGuoshuDelete(1);
            guoshu.setInsertTime(new Date());
            guoshu.setCreateTime(new Date());
            guoshuService.insert(guoshu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuoshuEntity guoshu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,guoshu:{}",this.getClass().getName(),guoshu.toString());
        GuoshuEntity oldGuoshuEntity = guoshuService.selectById(guoshu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(guoshu.getGuoshuPhoto()) || "null".equals(guoshu.getGuoshuPhoto())){
                guoshu.setGuoshuPhoto(null);
        }

            guoshuService.updateById(guoshu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GuoshuEntity> oldGuoshuList =guoshuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<GuoshuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            GuoshuEntity guoshuEntity = new GuoshuEntity();
            guoshuEntity.setId(id);
            guoshuEntity.setGuoshuDelete(2);
            list.add(guoshuEntity);
        }
        if(list != null && list.size() >0){
            guoshuService.updateBatchById(list);
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
            List<GuoshuEntity> guoshuList = new ArrayList<>();//上传的东西
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
                            GuoshuEntity guoshuEntity = new GuoshuEntity();
//                            guoshuEntity.setGuoyuanId(Integer.valueOf(data.get(0)));   //商家 要改的
//                            guoshuEntity.setGuoshuName(data.get(0));                    //果树名称 要改的
//                            guoshuEntity.setGuoshuUuidNumber(data.get(0));                    //果树编号 要改的
//                            guoshuEntity.setGuoshuPhoto("");//详情和图片
//                            guoshuEntity.setGuoshuAddress(data.get(0));                    //果树地点 要改的
//                            guoshuEntity.setGuoshuNewMoney(data.get(0));                    //果树认养费用 要改的
//                            guoshuEntity.setGuoshuTypes(Integer.valueOf(data.get(0)));   //果树类型 要改的
//                            guoshuEntity.setGuoshuKucunNumber(Integer.valueOf(data.get(0)));   //果树库存 要改的
//                            guoshuEntity.setGuoshuContent("");//详情和图片
//                            guoshuEntity.setGuoshuDelete(1);//逻辑删除字段
//                            guoshuEntity.setInsertTime(date);//时间
//                            guoshuEntity.setCreateTime(date);//时间
                            guoshuList.add(guoshuEntity);


                            //把要查询是否重复的字段放入map中
                                //果树编号
                                if(seachFields.containsKey("guoshuUuidNumber")){
                                    List<String> guoshuUuidNumber = seachFields.get("guoshuUuidNumber");
                                    guoshuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> guoshuUuidNumber = new ArrayList<>();
                                    guoshuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("guoshuUuidNumber",guoshuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //果树编号
                        List<GuoshuEntity> guoshuEntities_guoshuUuidNumber = guoshuService.selectList(new EntityWrapper<GuoshuEntity>().in("guoshu_uuid_number", seachFields.get("guoshuUuidNumber")).eq("guoshu_delete", 1));
                        if(guoshuEntities_guoshuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuoshuEntity s:guoshuEntities_guoshuUuidNumber){
                                repeatFields.add(s.getGuoshuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [果树编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        guoshuService.insertBatch(guoshuList);
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
        List<GuoshuView> returnGuoshuViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = guoshuOrderService.queryPage(params1);
        List<GuoshuOrderView> orderViewsList =(List<GuoshuOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(GuoshuOrderView orderView:orderViewsList){
            Integer guoshuTypes = orderView.getGuoshuTypes();
            if(typeMap.containsKey(guoshuTypes)){
                typeMap.put(guoshuTypes,typeMap.get(guoshuTypes)+1);
            }else{
                typeMap.put(guoshuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("guoshuTypes",type);
            PageUtils pageUtils1 = guoshuService.queryPage(params2);
            List<GuoshuView> guoshuViewList =(List<GuoshuView>)pageUtils1.getList();
            returnGuoshuViewList.addAll(guoshuViewList);
            if(returnGuoshuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = guoshuService.queryPage(params);
        if(returnGuoshuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnGuoshuViewList.size();//要添加的数量
            List<GuoshuView> guoshuViewList =(List<GuoshuView>)page.getList();
            for(GuoshuView guoshuView:guoshuViewList){
                Boolean addFlag = true;
                for(GuoshuView returnGuoshuView:returnGuoshuViewList){
                    if(returnGuoshuView.getId().intValue() ==guoshuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnGuoshuViewList.add(guoshuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnGuoshuViewList = returnGuoshuViewList.subList(0, limit);
        }

        for(GuoshuView c:returnGuoshuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnGuoshuViewList);
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
        PageUtils page = guoshuService.queryPage(params);

        //字典表数据转换
        List<GuoshuView> list =(List<GuoshuView>)page.getList();
        for(GuoshuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GuoshuEntity guoshu = guoshuService.selectById(id);
            if(guoshu !=null){


                //entity转view
                GuoshuView view = new GuoshuView();
                BeanUtils.copyProperties( guoshu , view );//把实体数据重构到view中

                //级联表
                    GuoyuanEntity guoyuan = guoyuanService.selectById(guoshu.getGuoyuanId());
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
    public R add(@RequestBody GuoshuEntity guoshu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,guoshu:{}",this.getClass().getName(),guoshu.toString());
        Wrapper<GuoshuEntity> queryWrapper = new EntityWrapper<GuoshuEntity>()
            .eq("guoyuan_id", guoshu.getGuoyuanId())
            .eq("guoshu_name", guoshu.getGuoshuName())
            .eq("guoshu_uuid_number", guoshu.getGuoshuUuidNumber())
            .eq("guoshu_address", guoshu.getGuoshuAddress())
            .eq("guoshu_types", guoshu.getGuoshuTypes())
            .eq("guoshu_kucun_number", guoshu.getGuoshuKucunNumber())
            .eq("guoshu_delete", guoshu.getGuoshuDelete())
//            .notIn("guoshu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuoshuEntity guoshuEntity = guoshuService.selectOne(queryWrapper);
        if(guoshuEntity==null){
            guoshu.setGuoshuDelete(1);
            guoshu.setInsertTime(new Date());
            guoshu.setCreateTime(new Date());
        guoshuService.insert(guoshu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

