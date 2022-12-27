package cn.yfwz100.tank4;

import cn.yfwz100.story.Actor;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;


public abstract class Bullet implements Actor {


    private Body body;


    private BaseTank owner;


    private boolean alive = true;


    protected Bullet(BaseTank owner, Vec2 pos, Vec2 vel) {
        this.owner = owner;

        BodyDef bodyDef = new BodyDef();
        bodyDef.position = pos;
        bodyDef.fixedRotation = true;
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.userData = this;
        body = getStory().getWorld().createBody(bodyDef);

        CircleShape circle = new CircleShape();
        circle.m_radius = 0.5f;
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 0.1f;
        fixtureDef.friction = 0;
        fixtureDef.shape = circle;
        body.createFixture(fixtureDef);

        body.setLinearVelocity(vel);
//        body.applyLinearImpulse(vel.mul(body.getMass()), body.getWorldCenter());
    }

    @Override
    public boolean update() {
        return alive;
    }


    public BaseTank getOwner() {
        return owner;
    }

    @Override
    public Tank4Story getStory() {
        return owner.getStory();
    }

    @Override
    public double getX() {
        return body.getWorldCenter().x;
    }

    @Override
    public double getY() {
        return body.getWorldCenter().y;
    }

    public void kill() {
        alive = false;
    }


    public int getPower() {
        return 10;
    }


    protected Body getBody() {
        return body;
    }

    @Override
    public void cleanup() {
        getStory().getWorld().destroyBody(body);
    }
}
