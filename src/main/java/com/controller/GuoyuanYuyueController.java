
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
 * 果园预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/guoyuanYuyue")
public class GuoyuanYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(GuoyuanYuyueController.class);

    private static final String TABLE_NAME = "guoyuanYuyue";

    @Autowired
    private GuoyuanYuyueService guoyuanYuyueService;


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
        CommonUtil.checkMap(params);
        PageUtils page = guoyuanYuyueService.queryPage(params);

        //字典表数据转换
        List<GuoyuanYuyueView> list =(List<GuoyuanYuyueView>)page.getList();
        for(GuoyuanYuyueView c:list){
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
        GuoyuanYuyueEntity guoyuanYuyue = guoyuanYuyueService.selectById(id);
        if(guoyuanYuyue !=null){
            //entity转view
            GuoyuanYuyueView view = new GuoyuanYuyueView();
            BeanUtils.copyProperties( guoyuanYuyue , view );//把实体数据重构到view中
            //级联表 果园
            //级联表
            GuoyuanEntity guoyuan = guoyuanService.selectById(guoyuanYuyue.getGuoyuanId());
            if(guoyuan != null){
            BeanUtils.copyProperties( guoyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGuoyuanId(guoyuan.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(guoyuanYuyue.getYonghuId());
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
    public R save(@RequestBody GuoyuanYuyueEntity guoyuanYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,guoyuanYuyue:{}",this.getClass().getName(),guoyuanYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            guoyuanYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<GuoyuanYuyueEntity> queryWrapper = new EntityWrapper<GuoyuanYuyueEntity>()
            .eq("guoyuan_id", guoyuanYuyue.getGuoyuanId())
            .eq("yonghu_id", guoyuanYuyue.getYonghuId())
            .in("guoyuan_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuoyuanYuyueEntity guoyuanYuyueEntity = guoyuanYuyueService.selectOne(queryWrapper);
        if(guoyuanYuyueEntity==null){
            guoyuanYuyue.setGuoyuanYuyueYesnoTypes(1);
            guoyuanYuyue.setInsertTime(new Date());
            guoyuanYuyue.setCreateTime(new Date());
            guoyuanYuyueService.insert(guoyuanYuyue);
            return R.ok();
        }else {
            if(guoyuanYuyueEntity.getGuoyuanYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(guoyuanYuyueEntity.getGuoyuanYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuoyuanYuyueEntity guoyuanYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,guoyuanYuyue:{}",this.getClass().getName(),guoyuanYuyue.toString());
        GuoyuanYuyueEntity oldGuoyuanYuyueEntity = guoyuanYuyueService.selectById(guoyuanYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            guoyuanYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            guoyuanYuyueService.updateById(guoyuanYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody GuoyuanYuyueEntity guoyuanYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,guoyuanYuyueEntity:{}",this.getClass().getName(),guoyuanYuyueEntity.toString());

        GuoyuanYuyueEntity oldGuoyuanYuyue = guoyuanYuyueService.selectById(guoyuanYuyueEntity.getId());//查询原先数据

//        if(guoyuanYuyueEntity.getGuoyuanYuyueYesnoTypes() == 2){//通过
//            guoyuanYuyueEntity.setGuoyuanYuyueTypes();
//        }else if(guoyuanYuyueEntity.getGuoyuanYuyueYesnoTypes() == 3){//拒绝
//            guoyuanYuyueEntity.setGuoyuanYuyueTypes();
//        }
        guoyuanYuyueEntity.setGuoyuanYuyueShenheTime(new Date());//审核时间
        guoyuanYuyueService.updateById(guoyuanYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GuoyuanYuyueEntity> oldGuoyuanYuyueList =guoyuanYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        guoyuanYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<GuoyuanYuyueEntity> guoyuanYuyueList = new ArrayList<>();//上传的东西
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
                            GuoyuanYuyueEntity guoyuanYuyueEntity = new GuoyuanYuyueEntity();
//                            guoyuanYuyueEntity.setGuoyuanYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            guoyuanYuyueEntity.setGuoyuanId(Integer.valueOf(data.get(0)));   //果园 要改的
//                            guoyuanYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            guoyuanYuyueEntity.setGuoyuanYuyueText(data.get(0));                    //报名理由 要改的
//                            guoyuanYuyueEntity.setGuoyuanYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            guoyuanYuyueEntity.setGuoyuanYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            guoyuanYuyueEntity.setGuoyuanYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            guoyuanYuyueEntity.setGuoyuanYuyueTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            guoyuanYuyueEntity.setInsertTime(date);//时间
//                            guoyuanYuyueEntity.setCreateTime(date);//时间
                            guoyuanYuyueList.add(guoyuanYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("guoyuanYuyueUuidNumber")){
                                    List<String> guoyuanYuyueUuidNumber = seachFields.get("guoyuanYuyueUuidNumber");
                                    guoyuanYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> guoyuanYuyueUuidNumber = new ArrayList<>();
                                    guoyuanYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("guoyuanYuyueUuidNumber",guoyuanYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<GuoyuanYuyueEntity> guoyuanYuyueEntities_guoyuanYuyueUuidNumber = guoyuanYuyueService.selectList(new EntityWrapper<GuoyuanYuyueEntity>().in("guoyuan_yuyue_uuid_number", seachFields.get("guoyuanYuyueUuidNumber")));
                        if(guoyuanYuyueEntities_guoyuanYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuoyuanYuyueEntity s:guoyuanYuyueEntities_guoyuanYuyueUuidNumber){
                                repeatFields.add(s.getGuoyuanYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        guoyuanYuyueService.insertBatch(guoyuanYuyueList);
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
        PageUtils page = guoyuanYuyueService.queryPage(params);

        //字典表数据转换
        List<GuoyuanYuyueView> list =(List<GuoyuanYuyueView>)page.getList();
        for(GuoyuanYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GuoyuanYuyueEntity guoyuanYuyue = guoyuanYuyueService.selectById(id);
            if(guoyuanYuyue !=null){


                //entity转view
                GuoyuanYuyueView view = new GuoyuanYuyueView();
                BeanUtils.copyProperties( guoyuanYuyue , view );//把实体数据重构到view中

                //级联表
                    GuoyuanEntity guoyuan = guoyuanService.selectById(guoyuanYuyue.getGuoyuanId());
                if(guoyuan != null){
                    BeanUtils.copyProperties( guoyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGuoyuanId(guoyuan.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(guoyuanYuyue.getYonghuId());
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
    public R add(@RequestBody GuoyuanYuyueEntity guoyuanYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,guoyuanYuyue:{}",this.getClass().getName(),guoyuanYuyue.toString());
        Wrapper<GuoyuanYuyueEntity> queryWrapper = new EntityWrapper<GuoyuanYuyueEntity>()
            .eq("guoyuan_yuyue_uuid_number", guoyuanYuyue.getGuoyuanYuyueUuidNumber())
            .eq("guoyuan_id", guoyuanYuyue.getGuoyuanId())
            .eq("yonghu_id", guoyuanYuyue.getYonghuId())
            .eq("guoyuan_yuyue_text", guoyuanYuyue.getGuoyuanYuyueText())
            .in("guoyuan_yuyue_yesno_types", new Integer[]{1,2})
            .eq("guoyuan_yuyue_yesno_text", guoyuanYuyue.getGuoyuanYuyueYesnoText())
//            .notIn("guoyuan_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuoyuanYuyueEntity guoyuanYuyueEntity = guoyuanYuyueService.selectOne(queryWrapper);
        if(guoyuanYuyueEntity==null){
            guoyuanYuyue.setGuoyuanYuyueYesnoTypes(1);
            guoyuanYuyue.setInsertTime(new Date());
            guoyuanYuyue.setCreateTime(new Date());
        guoyuanYuyueService.insert(guoyuanYuyue);

            return R.ok();
        }else {
            if(guoyuanYuyueEntity.getGuoyuanYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(guoyuanYuyueEntity.getGuoyuanYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

