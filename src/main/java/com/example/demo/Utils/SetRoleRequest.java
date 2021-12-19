package com.example.demo.Utils;

import lombok.Data;
import org.json.JSONObject;

@Data
public class SetRoleRequest {
    Integer setterId;
    String getterEmail;
    String role;
    public SetRoleRequest(String json) {
        JSONObject jsonObject = new JSONObject(json);
        this.setterId = jsonObject.getInt("setterId");
        this.getterEmail = jsonObject.getString("getterEmail");
        this.role = jsonObject.getString("role");
    }
}
