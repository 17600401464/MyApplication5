package com.example.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/8/4.
 */

public class Beantwo {

    /**
     * reason : 查询成功
     * result : {"title":"NBA2015-2016赛季_克里夫兰骑士_赛程赛果_球队阵容","list":[{"time":"06/13 09:00","m_time":"06-13 周二 09:00","player1":"骑士","player2":"勇士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/9.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"120-129","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470071","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470071","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470071","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470071","status":"2"},{"time":"07/08 06:30","m_time":"07-08 周六 06:30","player1":"雄鹿","player2":"骑士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/new/15.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=15","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"53-82","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470081","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470081","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470081","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470081","status":"2"},{"time":"07/09 10:00","m_time":"07-09 周日 10:00","player1":"火箭","player2":"骑士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/new/10.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=10","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"90-95","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470092","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470092","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470092","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470092","status":"2"},{"time":"07/11 08:30","m_time":"07-11 周二 08:30","player1":"勇士","player2":"骑士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/9.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"74-91","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470107","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470107","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470107","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470107","status":"2"},{"time":"07/14 10:30","m_time":"07-14 周五 10:30","player1":"湖人","player2":"骑士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/13.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=13","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"94-83","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470151","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470151","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470151","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470151","status":"2"},{"time":"07/15 10:30","m_time":"07-15 周六 10:30","player1":"骑士","player2":"猛龙","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/new/28.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=28","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"78-75","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470159","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470159","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470159","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470159","status":"2"}],"more1":{"link":"http://sports.qq.com/kbsweb/?ptag=360.onebox.team.nba#nba","text":""},"more2":{"link":"http://live.3g.qq.com/g/s?aid=nba","text":""}}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * title : NBA2015-2016赛季_克里夫兰骑士_赛程赛果_球队阵容
         * list : [{"time":"06/13 09:00","m_time":"06-13 周二 09:00","player1":"骑士","player2":"勇士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/9.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"120-129","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470071","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470071","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470071","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470071","status":"2"},{"time":"07/08 06:30","m_time":"07-08 周六 06:30","player1":"雄鹿","player2":"骑士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/new/15.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=15","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"53-82","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470081","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470081","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470081","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470081","status":"2"},{"time":"07/09 10:00","m_time":"07-09 周日 10:00","player1":"火箭","player2":"骑士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/new/10.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=10","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"90-95","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470092","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470092","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470092","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470092","status":"2"},{"time":"07/11 08:30","m_time":"07-11 周二 08:30","player1":"勇士","player2":"骑士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/9.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"74-91","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470107","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470107","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470107","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470107","status":"2"},{"time":"07/14 10:30","m_time":"07-14 周五 10:30","player1":"湖人","player2":"骑士","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/13.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=13","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"94-83","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470151","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470151","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470151","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470151","status":"2"},{"time":"07/15 10:30","m_time":"07-15 周六 10:30","player1":"骑士","player2":"猛龙","player1logo":"http://mat1.gtimg.com/sports/nba/logo/78/5.png","player2logo":"http://mat1.gtimg.com/sports/nba/logo/78/new/28.png","player1url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5","m_player1url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","player2url":"http://kbs.sports.qq.com/kbsweb/teams.htm?tid=28","m_player2url":"http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000","score":"78-75","link1text":"视频集锦","link1url":"http://sports.qq.com/kbsweb/game.htm?mid=100000:1470159","m_link1url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470159","link2text":"数据统计","link2url":"http://nba.stats.qq.com/nbascore/?mid=1470159","m_link2url":"http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470159","status":"2"}]
         * more1 : {"link":"http://sports.qq.com/kbsweb/?ptag=360.onebox.team.nba#nba","text":""}
         * more2 : {"link":"http://live.3g.qq.com/g/s?aid=nba","text":""}
         */

        private String title;
        private More1Bean more1;
        private More2Bean more2;
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public More1Bean getMore1() {
            return more1;
        }

        public void setMore1(More1Bean more1) {
            this.more1 = more1;
        }

        public More2Bean getMore2() {
            return more2;
        }

        public void setMore2(More2Bean more2) {
            this.more2 = more2;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class More1Bean {
            /**
             * link : http://sports.qq.com/kbsweb/?ptag=360.onebox.team.nba#nba
             * text :
             */

            private String link;
            private String text;

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class More2Bean {
            /**
             * link : http://live.3g.qq.com/g/s?aid=nba
             * text :
             */

            private String link;
            private String text;

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class ListBean {
            /**
             * time : 06/13 09:00
             * m_time : 06-13 周二 09:00
             * player1 : 骑士
             * player2 : 勇士
             * player1logo : http://mat1.gtimg.com/sports/nba/logo/78/5.png
             * player2logo : http://mat1.gtimg.com/sports/nba/logo/78/9.png
             * player1url : http://kbs.sports.qq.com/kbsweb/teams.htm?tid=5
             * m_player1url : http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000
             * player2url : http://kbs.sports.qq.com/kbsweb/teams.htm?tid=9
             * m_player2url : http://sports.qq.com/kbsweb/kbsshare/team.htm?cid=100000
             * score : 120-129
             * link1text : 视频集锦
             * link1url : http://sports.qq.com/kbsweb/game.htm?mid=100000:1470071
             * m_link1url : http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470071
             * link2text : 数据统计
             * link2url : http://nba.stats.qq.com/nbascore/?mid=1470071
             * m_link2url : http://sports.qq.com/kbsweb/kbsshare/game.htm?mid=100000:1470071
             * status : 2
             */

            private String time;
            private String m_time;
            private String player1;
            private String player2;
            private String player1logo;
            private String player2logo;
            private String player1url;
            private String m_player1url;
            private String player2url;
            private String m_player2url;
            private String score;
            private String link1text;
            private String link1url;
            private String m_link1url;
            private String link2text;
            private String link2url;
            private String m_link2url;
            private String status;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getM_time() {
                return m_time;
            }

            public void setM_time(String m_time) {
                this.m_time = m_time;
            }

            public String getPlayer1() {
                return player1;
            }

            public void setPlayer1(String player1) {
                this.player1 = player1;
            }

            public String getPlayer2() {
                return player2;
            }

            public void setPlayer2(String player2) {
                this.player2 = player2;
            }

            public String getPlayer1logo() {
                return player1logo;
            }

            public void setPlayer1logo(String player1logo) {
                this.player1logo = player1logo;
            }

            public String getPlayer2logo() {
                return player2logo;
            }

            public void setPlayer2logo(String player2logo) {
                this.player2logo = player2logo;
            }

            public String getPlayer1url() {
                return player1url;
            }

            public void setPlayer1url(String player1url) {
                this.player1url = player1url;
            }

            public String getM_player1url() {
                return m_player1url;
            }

            public void setM_player1url(String m_player1url) {
                this.m_player1url = m_player1url;
            }

            public String getPlayer2url() {
                return player2url;
            }

            public void setPlayer2url(String player2url) {
                this.player2url = player2url;
            }

            public String getM_player2url() {
                return m_player2url;
            }

            public void setM_player2url(String m_player2url) {
                this.m_player2url = m_player2url;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getLink1text() {
                return link1text;
            }

            public void setLink1text(String link1text) {
                this.link1text = link1text;
            }

            public String getLink1url() {
                return link1url;
            }

            public void setLink1url(String link1url) {
                this.link1url = link1url;
            }

            public String getM_link1url() {
                return m_link1url;
            }

            public void setM_link1url(String m_link1url) {
                this.m_link1url = m_link1url;
            }

            public String getLink2text() {
                return link2text;
            }

            public void setLink2text(String link2text) {
                this.link2text = link2text;
            }

            public String getLink2url() {
                return link2url;
            }

            public void setLink2url(String link2url) {
                this.link2url = link2url;
            }

            public String getM_link2url() {
                return m_link2url;
            }

            public void setM_link2url(String m_link2url) {
                this.m_link2url = m_link2url;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
