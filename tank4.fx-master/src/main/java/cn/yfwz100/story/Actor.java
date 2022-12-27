package cn.yfwz100.story;

import org.jbox2d.dynamics.World;


public interface Actor {

    /**
     * Update the actor.
     *
     * @return true if the actor is alive.
     */
    boolean update();

    /**
     * Get the story where the actor acts.
     *
     * @return the story.
     */
    Story getStory();

    /**
     * Clean up the stuff in world, which belongs to the actor.
     */
    default void cleanup() {}

    /**
     * Get the x-axis of the position.
     *
     * @return x-axis.
     */
    double getX();

    /**
     * Get the y-axis of the position.
     *
     * @return y-axis.
     */
    double getY();
}
