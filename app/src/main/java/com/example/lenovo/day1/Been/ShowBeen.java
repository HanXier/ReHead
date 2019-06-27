package com.example.lenovo.day1.Been;

import java.util.List;

public class ShowBeen {



    /**
     * ERRORCODE : 0
     * RESULT : {"movieNum":"11","movieList":[{"score":"7.6","movieTime":"122分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/09/171109.88229500_270X360X4.jpg","movieId":25412,"movieName":"阿丽塔：战斗天使"},{"score":"7.9","movieTime":"125分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/30/152305.14999287_100X140X4.jpg","movieId":218707,"movieName":"流浪地球"},{"score":"6.8","movieTime":"116分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/25/112700.66692130_100X140X4.jpg","movieId":230385,"movieName":"疯狂的外星人"},{"score":"7.2","movieTime":"98分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/07/141550.78907967_100X140X4.jpg","movieId":254868,"movieName":"飞驰人生"},{"score":"6.8","movieTime":"91分钟 ","movieImg":"http://img5.mtime.cn/mt/2018/11/27/084318.51885265_100X140X4.jpg","movieId":262215,"movieName":"熊出没·原始时代"},{"score":"","movieTime":"88分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/02/19/172006.34540643_100X140X4.jpg","movieId":262663,"movieName":"古井凶灵"},{"score":"6.9","movieTime":"91分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/02/02/113216.53857992_100X140X4.jpg","movieId":135808,"movieName":"新喜剧之王"},{"score":"5.5","movieTime":"122分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/24/095735.15787277_100X140X4.jpg","movieId":261355,"movieName":"一吻定情"},{"score":"5.9","movieTime":"108分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/15/164810.47339653_100X140X4.jpg","movieId":247293,"movieName":"神探蒲松龄"},{"score":"7.7","movieTime":"115分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/16/150422.99033371_100X140X4.jpg","movieId":253653,"movieName":"朝花夕誓\u2014\u2014于离别之朝束起约定之花"},{"score":"7.6","movieTime":"104分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/25/105549.53627008_100X140X4.jpg","movieId":190574,"movieName":"驯龙高手3"}]}
     */

    private String ERRORCODE;
    private RESULTBean RESULT;

    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }

    public RESULTBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(RESULTBean RESULT) {
        this.RESULT = RESULT;
    }

    public static class RESULTBean {
        /**
         * movieNum : 11
         * movieList : [{"score":"7.6","movieTime":"122分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/09/171109.88229500_270X360X4.jpg","movieId":25412,"movieName":"阿丽塔：战斗天使"},{"score":"7.9","movieTime":"125分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/30/152305.14999287_100X140X4.jpg","movieId":218707,"movieName":"流浪地球"},{"score":"6.8","movieTime":"116分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/25/112700.66692130_100X140X4.jpg","movieId":230385,"movieName":"疯狂的外星人"},{"score":"7.2","movieTime":"98分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/07/141550.78907967_100X140X4.jpg","movieId":254868,"movieName":"飞驰人生"},{"score":"6.8","movieTime":"91分钟 ","movieImg":"http://img5.mtime.cn/mt/2018/11/27/084318.51885265_100X140X4.jpg","movieId":262215,"movieName":"熊出没·原始时代"},{"score":"","movieTime":"88分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/02/19/172006.34540643_100X140X4.jpg","movieId":262663,"movieName":"古井凶灵"},{"score":"6.9","movieTime":"91分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/02/02/113216.53857992_100X140X4.jpg","movieId":135808,"movieName":"新喜剧之王"},{"score":"5.5","movieTime":"122分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/24/095735.15787277_100X140X4.jpg","movieId":261355,"movieName":"一吻定情"},{"score":"5.9","movieTime":"108分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/15/164810.47339653_100X140X4.jpg","movieId":247293,"movieName":"神探蒲松龄"},{"score":"7.7","movieTime":"115分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/16/150422.99033371_100X140X4.jpg","movieId":253653,"movieName":"朝花夕誓\u2014\u2014于离别之朝束起约定之花"},{"score":"7.6","movieTime":"104分钟 ","movieImg":"http://img5.mtime.cn/mt/2019/01/25/105549.53627008_100X140X4.jpg","movieId":190574,"movieName":"驯龙高手3"}]
         */

        private String movieNum;
        private List<MovieListBean> movieList;

        public String getMovieNum() {
            return movieNum;
        }

        public void setMovieNum(String movieNum) {
            this.movieNum = movieNum;
        }

        public List <MovieListBean> getMovieList() {
            return movieList;
        }

        public void setMovieList(List <MovieListBean> movieList) {
            this.movieList = movieList;
        }

        public static class MovieListBean {
            /**
             * score : 7.6
             * movieTime : 122分钟
             * movieImg : http://img5.mtime.cn/mt/2019/01/09/171109.88229500_270X360X4.jpg
             * movieId : 25412
             * movieName : 阿丽塔：战斗天使
             */

            private String score;
            private String movieTime;
            private String movieImg;
            private int movieId;
            private String movieName;

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getMovieTime() {
                return movieTime;
            }

            public void setMovieTime(String movieTime) {
                this.movieTime = movieTime;
            }

            public String getMovieImg() {
                return movieImg;
            }

            public void setMovieImg(String movieImg) {
                this.movieImg = movieImg;
            }

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public String getMovieName() {
                return movieName;
            }

            public void setMovieName(String movieName) {
                this.movieName = movieName;
            }
        }
    }
}
