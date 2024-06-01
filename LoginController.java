/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cqu.aise.client;

import com.cqu.aise.server.Constants;
import com.cqu.aise.server.DatabaseUtils;
import com.cqu.aise.server.SessionManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 61475
 */
public class LoginController implements Initializable {

    @FXML
    private Button adminRegisBtn;
    @FXML
    private TextField loginUserNameTextField;
    @FXML
    private Button loginBtn;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    private Button manageRegisBtn;
    @FXML
    private Button recruitRegisBtn;
    @FXML
    private ChoiceBox<String> loginUserTypeChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> userTypeList = Arrays.asList(
                Constants.UserType.ADMINSTAFF,
                Constants.UserType.MANAGEMENTSTAFF,
                Constants.UserType.RECRUIT
        );
        loginUserTypeChoiceBox.setItems(FXCollections.observableArrayList(userTypeList));
    }

    @FXML
    private void loginBtnHandler(ActionEvent event) {
        String username = loginUserNameTextField.getText();
        String password = loginPasswordField.getText();
        String userType = loginUserTypeChoiceBox.getValue();

        if (validateUser(username, password, userType)) {
            try {
                SessionManager.setCurrentUserName(username);
                SessionManager.setCurrentUserType(userType);
                App.setRoot("Home");
                System.out.println("Login successful!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 登录失败的处理逻辑
            System.out.println("Login failed, please check username, password, and user type");
        }
    }

    private boolean validateUser(String username, String password, String userType) {
        String tableName = null;
        switch (userType) {
            case Constants.UserType.ADMINSTAFF:
                tableName = "adminStaff";
                break;
            case Constants.UserType.MANAGEMENTSTAFF:
                tableName = "manageStaff";
                break;
            case Constants.UserType.RECRUIT:
                tableName = "recruits";
                break;
            default:
                System.out.println("Invalid user type: " + userType);
                return false;
        }

        String sql = "SELECT * FROM " + tableName + " WHERE userName = ? AND password = ?";

        try (Connection conn = DatabaseUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // 如果查询结果集有数据，则表示用户名和密码匹配成功
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void adminRegisBtnHandler(ActionEvent event) {
        try {
            App.setRoot("AdminRegis");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void manageRegisBtnHandler(ActionEvent event) {
        try {
            App.setRoot("ManageRegis");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void recruitRegisBtnHandler(ActionEvent event) {
        try {
            App.setRoot("RecruitRegis");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
