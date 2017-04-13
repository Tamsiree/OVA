package com.vondear.ova.bean;

import java.util.List;

/**
 * Created by vonde on 2017/1/9.
 */

public class JokeBean {

    /**
     * group : {"text":"昨天兄弟交了个女朋友，喊哥几个吃火锅，就当我们在里面夹菜的时候，她说了一句：你们能不能不在里面洗筷子，我都不想吃了。我瞬间好尴尬，但是没说话。今天他们分手了，我们又去那里吃火锅","neihan_hot_start_time":"00-00-00","dislike_reason":[{"type":2,"id":1,"title":"吧:内涵段子"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":9525436541,"title":"作者:有梦就追134117236"}],"create_time":1483878086,"id":53972433184,"favorite_count":0,"go_detail_count":2376,"user_favorite":0,"share_type":1,"user":{"user_id":9525436541,"name":"有梦就追134117236","followings":0,"user_verified":false,"ugc_count":2,"avatar_url":"http://wx.qlogo.cn/mmopen/7zwO3pRR033M6Y7jY5hibsiarX8vQKD6YKGfaricYnvJwWMbwR8Yia8LdZ3jZAjgFibIlq8jyq68wmLhjsDiaP7jZpWicrlpepmZJic0/64","followers":7,"is_following":false,"is_pro_user":false},"is_can_share":1,"category_type":1,"share_url":"http://m.neihanshequ.com/share/group/53972433184/?iid=4512422578&app=joke_essay","label":4,"content":"昨天兄弟交了个女朋友，喊哥几个吃火锅，就当我们在里面夹菜的时候，她说了一句：你们能不能不在里面洗筷子，我都不想吃了。我瞬间好尴尬，但是没说话。今天他们分手了，我们又去那里吃火锅","comment_count":22,"id_str":"53972433184","media_type":0,"share_count":27,"type":3,"status":102,"has_comments":0,"user_bury":0,"activity":{},"status_desc":"已发表","quick_comment":false,"display_type":0,"neihan_hot_end_time":"00-00-00","user_digg":0,"online_time":1483878086,"category_name":"内涵段子","category_visible":true,"bury_count":9,"is_anonymous":false,"repin_count":0,"is_neihan_hot":false,"digg_count":88,"has_hot_comments":1,"allow_dislike":true,"user_repin":0,"neihan_hot_link":{},"group_id":53972433184,"category_id":1}
     * comments : []
     * type : 1
     * display_time : 1483941313
     * online_time : 1483941313
     */

    private GroupBean group;
    private int type;

    public GroupBean getGroup() {
        return group;
    }

    public void setGroup(GroupBean group) {
        this.group = group;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static class GroupBean {
        /**
         * text : 昨天兄弟交了个女朋友，喊哥几个吃火锅，就当我们在里面夹菜的时候，她说了一句：你们能不能不在里面洗筷子，我都不想吃了。我瞬间好尴尬，但是没说话。今天他们分手了，我们又去那里吃火锅
         * neihan_hot_start_time : 00-00-00
         * dislike_reason : [{"type":2,"id":1,"title":"吧:内涵段子"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":9525436541,"title":"作者:有梦就追134117236"}]
         * create_time : 1483878086
         * id : 53972433184
         * favorite_count : 0
         * go_detail_count : 2376
         * user_favorite : 0
         * share_type : 1
         * user : {"user_id":9525436541,"name":"有梦就追134117236","followings":0,"user_verified":false,"ugc_count":2,"avatar_url":"http://wx.qlogo.cn/mmopen/7zwO3pRR033M6Y7jY5hibsiarX8vQKD6YKGfaricYnvJwWMbwR8Yia8LdZ3jZAjgFibIlq8jyq68wmLhjsDiaP7jZpWicrlpepmZJic0/64","followers":7,"is_following":false,"is_pro_user":false}
         * is_can_share : 1
         * category_type : 1
         * share_url : http://m.neihanshequ.com/share/group/53972433184/?iid=4512422578&app=joke_essay
         * label : 4
         * content : 昨天兄弟交了个女朋友，喊哥几个吃火锅，就当我们在里面夹菜的时候，她说了一句：你们能不能不在里面洗筷子，我都不想吃了。我瞬间好尴尬，但是没说话。今天他们分手了，我们又去那里吃火锅
         * comment_count : 22
         * id_str : 53972433184
         * media_type : 0
         * share_count : 27
         * type : 3
         * status : 102
         * has_comments : 0
         * user_bury : 0
         * activity : {}
         * status_desc : 已发表
         * quick_comment : false
         * display_type : 0
         * neihan_hot_end_time : 00-00-00
         * user_digg : 0
         * online_time : 1483878086
         * category_name : 内涵段子
         * category_visible : true
         * bury_count : 9
         * is_anonymous : false
         * repin_count : 0
         * is_neihan_hot : false
         * digg_count : 88
         * has_hot_comments : 1
         * allow_dislike : true
         * user_repin : 0
         * neihan_hot_link : {}
         * group_id : 53972433184
         * category_id : 1
         */

        private String text;
        private String neihan_hot_start_time;
        private int create_time;
        private long id;
        private int favorite_count;
        private int go_detail_count;
        private int user_favorite;
        private int share_type;
        private UserBean user;
        private int is_can_share;
        private int category_type;
        private String share_url;
        private int label;
        private String content;
        private int comment_count;
        private String id_str;
        private int media_type;
        private int share_count;
        private int type;
        private int status;
        private int has_comments;
        private int user_bury;
        private ActivityBean activity;
        private String status_desc;
        private boolean quick_comment;
        private int display_type;
        private String neihan_hot_end_time;
        private int user_digg;
        private int online_time;
        private String category_name;
        private boolean category_visible;
        private int bury_count;
        private boolean is_anonymous;
        private int repin_count;
        private boolean is_neihan_hot;
        private int digg_count;
        private int has_hot_comments;
        private boolean allow_dislike;
        private int user_repin;
        private NeihanHotLinkBean neihan_hot_link;
        private long group_id;
        private int category_id;
        private List<DislikeReasonBean> dislike_reason;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getNeihan_hot_start_time() {
            return neihan_hot_start_time;
        }

        public void setNeihan_hot_start_time(String neihan_hot_start_time) {
            this.neihan_hot_start_time = neihan_hot_start_time;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getFavorite_count() {
            return favorite_count;
        }

        public void setFavorite_count(int favorite_count) {
            this.favorite_count = favorite_count;
        }

        public int getGo_detail_count() {
            return go_detail_count;
        }

        public void setGo_detail_count(int go_detail_count) {
            this.go_detail_count = go_detail_count;
        }

        public int getUser_favorite() {
            return user_favorite;
        }

        public void setUser_favorite(int user_favorite) {
            this.user_favorite = user_favorite;
        }

        public int getShare_type() {
            return share_type;
        }

        public void setShare_type(int share_type) {
            this.share_type = share_type;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getIs_can_share() {
            return is_can_share;
        }

        public void setIs_can_share(int is_can_share) {
            this.is_can_share = is_can_share;
        }

        public int getCategory_type() {
            return category_type;
        }

        public void setCategory_type(int category_type) {
            this.category_type = category_type;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getId_str() {
            return id_str;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public int getMedia_type() {
            return media_type;
        }

        public void setMedia_type(int media_type) {
            this.media_type = media_type;
        }

        public int getShare_count() {
            return share_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getHas_comments() {
            return has_comments;
        }

        public void setHas_comments(int has_comments) {
            this.has_comments = has_comments;
        }

        public int getUser_bury() {
            return user_bury;
        }

        public void setUser_bury(int user_bury) {
            this.user_bury = user_bury;
        }

        public ActivityBean getActivity() {
            return activity;
        }

        public void setActivity(ActivityBean activity) {
            this.activity = activity;
        }

        public String getStatus_desc() {
            return status_desc;
        }

        public void setStatus_desc(String status_desc) {
            this.status_desc = status_desc;
        }

        public boolean isQuick_comment() {
            return quick_comment;
        }

        public void setQuick_comment(boolean quick_comment) {
            this.quick_comment = quick_comment;
        }

        public int getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        public String getNeihan_hot_end_time() {
            return neihan_hot_end_time;
        }

        public void setNeihan_hot_end_time(String neihan_hot_end_time) {
            this.neihan_hot_end_time = neihan_hot_end_time;
        }

        public int getUser_digg() {
            return user_digg;
        }

        public void setUser_digg(int user_digg) {
            this.user_digg = user_digg;
        }

        public int getOnline_time() {
            return online_time;
        }

        public void setOnline_time(int online_time) {
            this.online_time = online_time;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public boolean isCategory_visible() {
            return category_visible;
        }

        public void setCategory_visible(boolean category_visible) {
            this.category_visible = category_visible;
        }

        public int getBury_count() {
            return bury_count;
        }

        public void setBury_count(int bury_count) {
            this.bury_count = bury_count;
        }

        public boolean isIs_anonymous() {
            return is_anonymous;
        }

        public void setIs_anonymous(boolean is_anonymous) {
            this.is_anonymous = is_anonymous;
        }

        public int getRepin_count() {
            return repin_count;
        }

        public void setRepin_count(int repin_count) {
            this.repin_count = repin_count;
        }

        public boolean isIs_neihan_hot() {
            return is_neihan_hot;
        }

        public void setIs_neihan_hot(boolean is_neihan_hot) {
            this.is_neihan_hot = is_neihan_hot;
        }

        public int getDigg_count() {
            return digg_count;
        }

        public void setDigg_count(int digg_count) {
            this.digg_count = digg_count;
        }

        public int getHas_hot_comments() {
            return has_hot_comments;
        }

        public void setHas_hot_comments(int has_hot_comments) {
            this.has_hot_comments = has_hot_comments;
        }

        public boolean isAllow_dislike() {
            return allow_dislike;
        }

        public void setAllow_dislike(boolean allow_dislike) {
            this.allow_dislike = allow_dislike;
        }

        public int getUser_repin() {
            return user_repin;
        }

        public void setUser_repin(int user_repin) {
            this.user_repin = user_repin;
        }

        public NeihanHotLinkBean getNeihan_hot_link() {
            return neihan_hot_link;
        }

        public void setNeihan_hot_link(NeihanHotLinkBean neihan_hot_link) {
            this.neihan_hot_link = neihan_hot_link;
        }

        public long getGroup_id() {
            return group_id;
        }

        public void setGroup_id(long group_id) {
            this.group_id = group_id;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public List<DislikeReasonBean> getDislike_reason() {
            return dislike_reason;
        }

        public void setDislike_reason(List<DislikeReasonBean> dislike_reason) {
            this.dislike_reason = dislike_reason;
        }

        public static class UserBean {
            /**
             * user_id : 9525436541
             * name : 有梦就追134117236
             * followings : 0
             * user_verified : false
             * ugc_count : 2
             * avatar_url : http://wx.qlogo.cn/mmopen/7zwO3pRR033M6Y7jY5hibsiarX8vQKD6YKGfaricYnvJwWMbwR8Yia8LdZ3jZAjgFibIlq8jyq68wmLhjsDiaP7jZpWicrlpepmZJic0/64
             * followers : 7
             * is_following : false
             * is_pro_user : false
             */

            private long user_id;
            private String name;
            private int followings;
            private boolean user_verified;
            private int ugc_count;
            private String avatar_url;
            private int followers;
            private boolean is_following;
            private boolean is_pro_user;

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getFollowings() {
                return followings;
            }

            public void setFollowings(int followings) {
                this.followings = followings;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public int getUgc_count() {
                return ugc_count;
            }

            public void setUgc_count(int ugc_count) {
                this.ugc_count = ugc_count;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public int getFollowers() {
                return followers;
            }

            public void setFollowers(int followers) {
                this.followers = followers;
            }

            public boolean isIs_following() {
                return is_following;
            }

            public void setIs_following(boolean is_following) {
                this.is_following = is_following;
            }

            public boolean isIs_pro_user() {
                return is_pro_user;
            }

            public void setIs_pro_user(boolean is_pro_user) {
                this.is_pro_user = is_pro_user;
            }
        }

        public static class ActivityBean {
        }

        public static class NeihanHotLinkBean {
        }

        public static class DislikeReasonBean {
        }
    }
}

