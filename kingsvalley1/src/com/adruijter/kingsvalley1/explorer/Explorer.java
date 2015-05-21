 package com.adruijter.kingsvalley1.explorer;

import com.adruijter.kingsvalley1.KingsValley1;
import com.adruijter.kingsvalley1.animatedsprite.AnimatedSprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Explorer 
{

	//Fields
    private KingsValley1 game;
    private Vector2 position;
    private Texture texture;
    private Rectangle rectangle;
    private Rectangle collisionRectStairs;
    private Texture collisionText;
    private float speed = 1;
    private AnimatedSprite state;
    private ExplorerIdleRight idleRight;
    
    /*
    private ExplorerWalkRight walkRight;
    private ExplorerWalkLeft walkLeft;
    private ExplorerIdleLeft idleLeft;
    private ExplorerJumpRight jumpRight;
    private ExplorerJumpLeft jumpLeft;
    private ExplorerIdleJumpRight idleJumpRight;
    private ExplorerIdleJumpLeft idleJumpLeft;
    private ExplorerWalkUpStairsRight walkUpStairsRight;
    private ExplorerIdleUpStairsRight idleUpStairsRight;
    private ExplorerWalkDownStairsRight walkDownStairsRight;
    private ExplorerIdleDownStairsRight idleDownStairsRight;
    private ExplorerWalkUpStairsLeft walkUpStairsLeft;
    private ExplorerIdleUpStairsLeft idleUpStairsLeft;
    private ExplorerWalkDownStairsLeft walkDownStairsLeft;
    private ExplorerIdleDownStairsLeft idleDownStairsLeft;
    */

    //Properties
    public Vector2 getPosition()
    {
        return this.position;
    }
    public void setPosition(Vector2 position)
    { 
        this.position = position;
        this.rectangle.x = this.position.x;
        this.rectangle.y = this.position.y;
    }
    public float getSpeed()
    {
        return this.speed;
    }
    public KingsValley1 getGame()
    {
        return this.game;
    }
    public Texture getTexture()
    {
        return this.texture;
    }
    public Rectangle getRectangle()
    {
        return this.rectangle;
    }
    public Rectangle getCollisionRectStairs()
    {
        return this.collisionRectStairs;
    }
    public void setCollisionRectStairs(Rectangle collisionRectStairs)
    { 
    	this.collisionRectStairs = collisionRectStairs; 
    }
    public Texture getCollisionText()
    {
        return this.collisionText;
    }
    public AnimatedSprite getState()
    {
        return this.state;
    }
    public void setState(AnimatedSprite state)
    {
    	this.state = state;
    }
    public ExplorerIdleRight getIdleRight()
    {
        return this.idleRight;
    }
    /*
    public ExplorerWalkRight WalkRight
    {
        set { this.walkRight = value; }
        get { return this.walkRight; }
    }
    
    public ExplorerWalkLeft WalkLeft
    {
        get { return this.walkLeft; }
    }
    public ExplorerIdleLeft IdleLeft
    {
        get { return this.idleLeft; }
    }
    public ExplorerJumpRight JumpRight
    {
        get { return this.jumpRight; }
    }
    public ExplorerJumpLeft JumpLeft
    {
        get { return this.jumpLeft; }
    }
    public ExplorerIdleJumpRight IdleJumpRight
    {
        get { return this.idleJumpRight; }
    }
    public ExplorerIdleJumpLeft IdleJumpLeft
    {
        get { return this.idleJumpLeft; }
        set { this.idleJumpLeft = value; }
    }
    public ExplorerWalkUpStairsRight WalkUpStairsRight
    {
        get { return this.walkUpStairsRight; }
        set { this.walkUpStairsRight = value; }
    }
    public ExplorerIdleUpStairsRight IdleUpStairsRight
    {
        get { return this.idleUpStairsRight; }
        set { this.idleUpStairsRight = value; }
    }
    public ExplorerWalkDownStairsRight WalkDownStairsRight
    {
        get { return this.walkDownStairsRight; }
        set { this.walkDownStairsRight = value; }
    }
    public ExplorerIdleDownStairsRight IdleDownStairsRight
    {
        get { return this.idleDownStairsRight; }
        set { this.idleDownStairsRight = value; }
    }
    public ExplorerWalkUpStairsLeft WalkUpStairsLeft
    {
        get { return this.walkUpStairsLeft; }
    }
    public ExplorerIdleUpStairsLeft IdleUpStairsLeft
    {
        get { return this.idleUpStairsLeft; }
    }
    public ExplorerWalkDownStairsLeft WalkDownStairsLeft
    {
        get { return this.walkDownStairsLeft; }
    }
    public ExplorerIdleDownStairsLeft IdleDownStairsLeft
    {
        get { return this.idleDownStairsLeft; }
    }
*/

    //Constructor
    public Explorer(KingsValley1 game, Vector2 position)
    {
        this.game = game;
        this.position = position;
        this.texture = new Texture("data/explorer.png");
        this.rectangle = new Rectangle(this.position.x,
                                       this.position.y,
                                       this.texture.getWidth() / 8f,
                                       this.texture.getHeight());
        this.collisionText = new Texture("data/Stairs/collision_text.png");
        this.collisionRectStairs = new Rectangle(this.position.x,
                                                 this.position.y + 16f,
                                                 16f,
                                                 16f);
        this.idleRight = new ExplorerIdleRight(this);
        
        /*
        this.walkRight = new ExplorerWalkRight(this);        
        this.walkLeft = new ExplorerWalkLeft(this);
        this.idleLeft = new ExplorerIdleLeft(this);
        this.jumpRight = new ExplorerJumpRight(this, 20, 32);
        this.jumpLeft = new ExplorerJumpLeft(this, -20, 32);
        this.idleJumpRight = new ExplorerIdleJumpRight(this, 20, 32);
        this.idleJumpLeft = new ExplorerIdleJumpLeft(this, 20, 32);
        this.walkUpStairsRight = new ExplorerWalkUpStairsRight(this);
        this.idleUpStairsRight = new ExplorerIdleUpStairsRight(this);
        this.walkDownStairsRight = new ExplorerWalkDownStairsRight(this);
        this.idleDownStairsRight = new ExplorerIdleDownStairsRight(this);
        this.walkUpStairsLeft = new ExplorerWalkUpStairsLeft(this);
        this.idleUpStairsLeft = new ExplorerIdleUpStairsLeft(this);
        this.walkDownStairsLeft = new ExplorerWalkDownStairsLeft(this);
        this.idleDownStairsLeft = new ExplorerIdleDownStairsLeft(this);
        */
        
        this.state = this.idleRight;

    }

    //Update
    public void Update(float delta)
    {
        //ExplorerManager.Explorer = this;
        this.state.Update(delta);           
    }

    //Draw
    public void Draw(float delta)
    {
        this.state.Draw(delta);
    }
}
