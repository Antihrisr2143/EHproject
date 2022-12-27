package cn.yfwz100.tank4;

import cn.yfwz100.story.ActorIterator;
import cn.yfwz100.story.Story;

import java.util.Collection;
import java.util.Iterator;


public interface Tank4Story extends Story {


    Collection<Bullet> getBullets();


    Collection<BaseTank> getTanks();


    Collection<Block> getBlocks();


    PlayerTank getPlayer();

    @Override
    default ActorIterator actorIterator() {
        return new ActorIterator(
                getBlocks().iterator(),
                getTanks().iterator(),
                getBullets().iterator(),
                new SingleTankIterator(getPlayer(), this::onEndEvent)
        );
    }

    @Override
    TankScoreBoard getScoreBoard();


    void onEndEvent();


    class SingleTankIterator implements Iterator<PlayerTank> {

        private PlayerTank tank;
        private boolean hasNext = true;
        private Runnable onEndEvent;

        SingleTankIterator(PlayerTank tank, Runnable onEndEvent) {
            this.tank = tank;
            this.onEndEvent = onEndEvent;
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public PlayerTank next() {
            hasNext = false;
            return tank;
        }

        @Override
        public void remove() {
            this.onEndEvent.run();
        }
    }
}
