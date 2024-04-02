package lk.ijse.dep12.mini_game.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MainViewController {
    public AnchorPane root;
    public Label lblMan;
    public Label lblBackground2;
    public Label lblBackground1;
    private final Timeline TIME_LINE = new Timeline();
    public Label lblObject;
    public Label lblObject2;
    public Label lblBTC;
    public Label lblCoin;

    public void initialize() {
        lblBackground2.setLayoutY(lblBackground1.getLayoutY());
        lblBackground2.setLayoutX(lblBackground1.getLayoutX() + 819);

        Platform.runLater(() -> {
            root.getScene()
                    .setOnKeyPressed(keyEvent -> {
                        if (keyEvent.getCode() == KeyCode.SPACE) {
                            lblMan.setLayoutY(lblMan.getLayoutY() - 200);
                            if (lblMan.getLayoutY() < 100) lblMan.setLayoutY(320);
                        }
                    });
        });

        KeyFrame kf1 = new KeyFrame(Duration.millis(400), actionEvent -> {
            if (lblObject.getLayoutX() < -20) lblObject.setLayoutX(860);
            else {
                lblObject.setLayoutX(lblObject.getLayoutX() - 20);

                if (lblObject.getLayoutX()  == lblMan.getLayoutX() && lblMan.getLayoutY() == lblObject.getLayoutY()) {
                    lblMan.setVisible(false);
                }
            }
        });

        KeyFrame kf2 = new KeyFrame(Duration.millis(0), actionEvent -> {
            if (lblBackground1.getLayoutX() == -820) lblBackground1.setLayoutX(0);
            else lblBackground1.setLayoutX(lblBackground1.getLayoutX() - 20);
            lblBackground2.setLayoutX(lblBackground1.getLayoutX() + 819);
        });

        KeyFrame kf3 = new KeyFrame(Duration.millis(300), actionEvent -> {
            if (lblObject2.getLayoutX() < -20) lblObject2.setLayoutX(860);
            else {
                lblObject2.setLayoutX(lblObject2.getLayoutX() - 20);

                if (lblObject2.getLayoutX() == lblMan.getLayoutX() && lblObject2.getLayoutY() == lblMan.getLayoutY()) {
                    lblMan.setVisible(false);
                }
            }
        });

        KeyFrame kf4 = new KeyFrame(Duration.millis(500), actionEvent -> {
            if (lblCoin.getLayoutX() < -20) lblCoin.setLayoutX(860);
            else {
                lblCoin.setLayoutX(lblCoin.getLayoutX() - 20);

                if (lblCoin.getLayoutX() == lblMan.getLayoutX() && lblCoin.getLayoutY() == lblMan.getLayoutY()) {
                    lblCoin.setVisible(false);
                }
            }
        });

        KeyFrame kf5 = new KeyFrame(Duration.millis(400), actionEvent -> {
            if(lblBTC.getLayoutX() < -20) lblBTC.setLayoutX(860);
            else {
                lblBTC.setLayoutX(lblBTC.getLayoutX() - 20);

                if (lblBTC.getLayoutX() == lblMan.getLayoutX() && lblBTC.getLayoutY() == lblMan.getLayoutY()) {
                    lblBTC.setVisible(false);
                }
            }
        });

        TIME_LINE.getKeyFrames().addAll(kf1, kf2,kf3, kf4, kf5);
        TIME_LINE.setCycleCount(Animation.INDEFINITE);
        TIME_LINE.setAutoReverse(true);
        TIME_LINE.play();
    }
}
