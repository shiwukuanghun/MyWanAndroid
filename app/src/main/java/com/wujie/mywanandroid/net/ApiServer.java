package com.wujie.mywanandroid.net;



import com.wujie.commonmoudle.bean.BaseBean;
import com.wujie.mywanandroid.bean.NavigationBean;
import com.wujie.mywanandroid.bean.TodoBean;
import com.wujie.mywanandroid.bean.BannerBean;
import com.wujie.mywanandroid.bean.HomeBean;
import com.wujie.mywanandroid.bean.HttpsRequest;
import com.wujie.mywanandroid.bean.KnowledgeBean;
import com.wujie.mywanandroid.bean.PageListDataBean;
import com.wujie.mywanandroid.bean.ProjectItemBean;
import com.wujie.mywanandroid.bean.ProjectTypeBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by HuangBin on 2018/11/15 10:44.
 * Description：
 */

public interface ApiServer {

    //首页文章列表
    @GET("article/list/{page}/json")
    Observable<BaseBean<PageListDataBean<HomeBean>>> getHomeList(@Path("page") int page);

    //轮播图
    @GET("banner/json")
    Observable<BaseBean<List<BannerBean>>> getBanner();

    //登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseBean<Object>> login(@Field("username") String username, @Field("password") String password);

    //退出登录
    @GET("user/logout/json")
    Observable<BaseBean<Object>> logout();

    //注册
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseBean<Object>> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

//Latitude=39.922705&Longitude=116.416636&start=0&productName=华为&limit=10
    @POST("shop/queryNearShop")
    Observable<Object> getResult(@Body HttpsRequest httpsRequest);
//    Observable<Object> getReuslt(@Query("Latitude") String Latitude, @Query("Longitude") String Longitude, @Query("start") int start, @Query("productName") String productName, @Query("limit") int limit);


    @POST("lg/collect/{id}/json")
    Observable<BaseBean<Object>> collectArticle(@Path("id") int id);


    @POST("lg/collect/{id}/json")
    Observable<BaseBean<Object>> collectInsideArticle(@Path("id") int id);

    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseBean<Object>> unCollectArticle(@Path("id") int id);

    @GET("tree/json")
    Observable<BaseBean<List<KnowledgeBean>>> getKnowledge();

    @GET("project/tree/json")
    Observable<BaseBean<List<ProjectTypeBean>>> getProjectType();

    @GET("project/list/1/json")
    Observable<BaseBean<PageListDataBean<ProjectItemBean>>> getProjectList(@Query("cid") int cid);

    //添加TODO
    @POST("lg/todo/add/json")
    @FormUrlEncoded
    Observable<BaseBean<TodoBean>> addTodo(@Field("title") String title, @Field("content") String content, @Field("date") String date, @Field("type") int type, @Field("priority") int priority);
//    Observable<BaseBean<TodoBean>> addTodo(@Query("title") String title, @Query("content") String content, @Query("date") String date, @Query("type") int type, @Query("priority") int priority);

    //TODO列表
    @POST("lg/todo/v2/list/{page}/json")
    @FormUrlEncoded
    Observable<BaseBean<PageListDataBean<TodoBean>>> getTodoList(@Path("page") int page, @Field("status") int status, @Field("type") int type, @Field("priority") int priority, @Field("orderby") int orderby);

    @GET("navi/json")
    Observable<BaseBean<List<NavigationBean>>> getNavigation();
}
