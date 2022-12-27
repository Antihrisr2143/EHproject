package cn.yfwz100.tank4;

import java.util.Map;

import cn.yfwz100.story.ScoreBoard;


public interface TankScoreBoard extends ScoreBoard {


    int getMaxKillTimes();


    Map<Integer, Integer> getKillTimesCounter();


    default String getDescription() {
        double score = getScore();
        if (score < 100) {
            return "Needs Fighting!";
        } else if (score < 500) {
            return "Ordinary Hero!";
        } else {
            return "Extraordinary!";
        }
    }
}
