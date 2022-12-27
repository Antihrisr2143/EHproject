package cn.yfwz100.story.fx;

import javafx.scene.canvas.GraphicsContext;


public interface ActorGraphics {

    /**
     * The draw strategy.
     *
     * @param g the graphics context.
     */
    void paint(GraphicsContext g);

}
