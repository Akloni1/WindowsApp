package sample.animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class EnterShake {
    private TranslateTransition tt;

    public EnterShake  (Node node){
        tt = new  TranslateTransition(Duration.millis(80),node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }
    public void playAnim(){
        tt.playFromStart();//выполняет проигрывание нашей анимации
    }
}
