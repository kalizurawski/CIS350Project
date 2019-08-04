package GameProject;

public interface SpaceCommons {

    /** board width. **/
    int BOARD_WIDTH = 500;
    /** board height. **/
    int BOARD_HEIGHT = 500;
    /** board metric. **/
    int BOARD_METRIC = 50;
    /** font size. **/
    int FONT_SIZE = 14;
    /** ground. **/
    int GROUND = 300;
    /** bomb height. **/
    int BOMB_HEIGHT = 20;
    /** bomb width. **/
    int BOMB_WIDTH = 20;
    /** explosion height. **/
    int EXP_HEIGHT = 40;
    /** explosion width. **/
    int EXP_WIDTH = 40;
    /** alien height. **/
    int ALIEN_HEIGHT = 30;
    /** alien width. **/
    int ALIEN_WIDTH = 30;
    /** right border. **/
    int BORDER_RIGHT = 30;
    /** left border. **/
    int BORDER_LEFT = 5;
    /** down constant. **/
    int GO_DOWN = 15;
    /** total number of aliens. **/
    int NUMBER_OF_ALIENS_TO_DESTROY = 24;
    /** rows of aliens. **/
    int ALIEN_ROWS = 4;
    /** cols of aliens. **/
    int ALIEN_COLS = NUMBER_OF_ALIENS_TO_DESTROY / ALIEN_ROWS;
    /** space between aliens. **/
    int SPACE_BETWEEN_ALIENS = 30;
    /** 1/chance of bomb being dropped from alien. **/
    int CHANCE = 250;
    /** total delay. **/
    int DELAY = 20;
    /** width of player. **/
    int PLAYER_WIDTH = 50;
    /** height of player. **/
    int PLAYER_HEIGHT = 50;
    /** player starting lives. **/
    int PLAYER_LIVES = 3;
    /** shot speed. **/
    int SHOT_SPEED = 6;
}
