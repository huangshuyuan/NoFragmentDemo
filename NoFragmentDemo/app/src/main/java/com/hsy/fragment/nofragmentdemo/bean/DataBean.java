package com.hsy.fragment.nofragmentdemo.bean;

import java.util.List;

/**
 * 作者：huangshuyuan on 2017/5/19 13:53
 * 邮箱：hshuyuan@foxmail.com
 */

public class DataBean {

    /**
     * error : false
     * results : [{"_id":"59197e87421aa92c7be61afe","createdAt":"2017-05-15T18:10:15.604Z","desc":"Android灵魂画家的18种混合模式","publishedAt":"2017-05-16T12:10:38.580Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247484408&idx=1&sn=cd077ffe234b15c6c8a193def53fc963&chksm=96cda2b5a1ba2ba387c910df7b864580f6f5858691bcecb46afe2b8a91684ab804879f01d905&mpshare=1&scene=23&srcid=0515GJX6SNr5N7p6B7bkqG1y#rd","used":true,"who":"陈宇明"},{"_id":"5919c31a421aa92c73b64703","createdAt":"2017-05-15T23:02:50.754Z","desc":"这次我们抛开术语和概念，从例子入手，由浅入深地讲解 Java 的类加载机制。","images":["http://img.gank.io/8c728347-b326-4d41-b7b5-f8e748e65db0"],"publishedAt":"2017-05-16T12:10:38.580Z","source":"web","type":"Android","url":"http://wingjay.com/2017/05/08/java_classloader/","used":true,"who":"wingjay"},{"_id":"5919c512421aa92c769a8b5e","createdAt":"2017-05-15T23:11:14.879Z","desc":"Android setContentView源码分析","images":["http://img.gank.io/4eaa8f16-3acb-4a84-af07-b8e0c63690d4"],"publishedAt":"2017-05-16T12:10:38.580Z","source":"web","type":"Android","url":"http://rkhcy.github.io/2017/05/16/setContentView%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90/","used":true,"who":"HuYounger"},{"_id":"5919c7bb421aa92c769a8b5f","createdAt":"2017-05-15T23:22:35.126Z","desc":"Android电量优化的点点滴滴，全告诉你！","publishedAt":"2017-05-16T12:10:38.580Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzI3OTU3OTQ1Mw==&mid=2247483773&idx=1&sn=e7756fbd318aeadd77cf16251450f8aa&chksm=eb44df2fdc3356399c2518df6ecc14473266be608da4d14368a7a7f01bed8a6020a086ddc5ee&mpshare=1&scene=23&srcid=0515azWSHTyEo0IV32hU41rG#rd","used":true,"who":null},{"_id":"591a55fb421aa92c794632c9","createdAt":"2017-05-16T09:29:31.273Z","desc":"横向堆叠效果的自定义Layout","images":["http://img.gank.io/b6a9c5b4-a6da-4bfa-8423-14b10a5c0d50"],"publishedAt":"2017-05-16T12:10:38.580Z","source":"web","type":"Android","url":"https://github.com/xmuSistone/android-pile-layout","used":true,"who":"stone"},{"_id":"591a63e3421aa92c794632cb","createdAt":"2017-05-16T10:28:51.893Z","desc":"用算法来实现祛斑磨皮，效果很显著呢。","images":["http://img.gank.io/86e0e94e-baad-4dd3-88be-0a80ff6db32b","http://img.gank.io/bb951615-119e-498c-a3a6-8678ed2e9e62"],"publishedAt":"2017-05-16T12:10:38.580Z","source":"chrome","type":"Android","url":"https://github.com/ufoym/RecursiveBF","used":true,"who":"代码家"},{"_id":"591710a5421aa91c8da340c1","createdAt":"2017-05-13T21:56:53.918Z","desc":"一个用粒子动画显示文字的 Android 自定义 View","images":["http://img.gank.io/396faa3f-94bc-4eb5-9ec3-dafe0650fcbe"],"publishedAt":"2017-05-15T12:03:44.165Z","source":"chrome","type":"Android","url":"https://github.com/Yasic/ParticleTextView?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=5740","used":true,"who":"jp"},{"_id":"59171729421aa91c8da340c2","createdAt":"2017-05-13T22:24:41.124Z","desc":"Tucao.tv 自制第三方Android客户端，Kotlin+DataBinding+RxJava+Dagger2+Retrofit，还有酷酷的Material Design Transition~","publishedAt":"2017-05-15T12:03:44.165Z","source":"web","type":"Android","url":"https://github.com/blackbbc/Tucao","used":true,"who":"Sweet"},{"_id":"5918e819421aa91c82fa666b","createdAt":"2017-05-15T07:28:25.874Z","desc":"RxJava 实现的主题切换引擎！","images":["http://img.gank.io/3b2b976a-cfc5-4a39-8582-9c0ee562b955"],"publishedAt":"2017-05-15T12:03:44.165Z","source":"chrome","type":"Android","url":"https://github.com/afollestad/aesthetic","used":true,"who":"代码家"},{"_id":"5912bdd1421aa90c7d49ad7b","createdAt":"2017-05-10T15:14:25.860Z","desc":"展示一下我的Gank客户端，具有用户登录注册，干货收藏等新功能。","images":["http://img.gank.io/fb793e2f-ede0-4ee5-853e-2d7e908addf2","http://img.gank.io/b0a680d5-fc99-46f6-9ccf-bc7d2c3a6da6"],"publishedAt":"2017-05-12T13:44:54.673Z","source":"web","type":"Android","url":"https://github.com/mask-hao/MyGank","used":true,"who":"张浩"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 59197e87421aa92c7be61afe
         * createdAt : 2017-05-15T18:10:15.604Z
         * desc : Android灵魂画家的18种混合模式
         * publishedAt : 2017-05-16T12:10:38.580Z
         * source : web
         * type : Android
         * url : https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247484408&idx=1&sn=cd077ffe234b15c6c8a193def53fc963&chksm=96cda2b5a1ba2ba387c910df7b864580f6f5858691bcecb46afe2b8a91684ab804879f01d905&mpshare=1&scene=23&srcid=0515GJX6SNr5N7p6B7bkqG1y#rd
         * used : true
         * who : 陈宇明
         * images : ["http://img.gank.io/8c728347-b326-4d41-b7b5-f8e748e65db0"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
