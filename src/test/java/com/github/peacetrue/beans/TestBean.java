package com.github.peacetrue.beans;

import com.github.peacetrue.beans.createmodify.CreateModify;
import com.github.peacetrue.beans.properties.clientid.ClientId;
import com.github.peacetrue.beans.properties.code.Code;
import com.github.peacetrue.beans.properties.context.Context;
import com.github.peacetrue.beans.properties.data.Data;
import com.github.peacetrue.beans.properties.deleted.Deleted;
import com.github.peacetrue.beans.properties.id.Id;
import com.github.peacetrue.beans.properties.id.IdCapable;
import com.github.peacetrue.beans.properties.message.Message;
import com.github.peacetrue.beans.properties.name.Name;
import com.github.peacetrue.beans.properties.nonce.Nonce;
import com.github.peacetrue.beans.properties.ownerid.OwnerId;
import com.github.peacetrue.beans.properties.password.Password;
import com.github.peacetrue.beans.properties.requestid.RequestId;
import com.github.peacetrue.beans.properties.serialnumber.SerialNumber;
import com.github.peacetrue.beans.properties.signature.Signature;
import com.github.peacetrue.beans.properties.success.Success;
import com.github.peacetrue.beans.properties.timestamp.Timestamp;
import com.github.peacetrue.beans.properties.username.Username;
import com.github.peacetrue.beans.properties.value.Value;
import com.github.peacetrue.beans.properties.version.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author peace
 **/
@Getter
@Setter
@ToString
@Accessors(chain = true, fluent = true)
public class TestBean implements
        Id<Long>, Code, Name, Value,
        Username, Password, SerialNumber<Long>,
        OwnerId<Long>, Deleted, Version,
        RequestId, Context<String>, Success, Message, Data<String>,
        ClientId, Nonce, Timestamp, Signature,
        CreateModify<Long, LocalDateTime> {
    private Long id;
    private String code;
    private String name;
    private String username;
    private String password;
    private String value;
    private Long version;
    private String context;
    private Boolean deleted;
    private Long ownerId;
    private String requestId;
    private Long serialNumber;
    private String clientId;
    private String nonce;
    private Long timestamp;
    private String signature;
    private Boolean success;
    private String message;
    private String data;
    private Long creatorId;
    private LocalDateTime createdTime;
    private Long modifierId;
    private LocalDateTime modifiedTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String getContext() {
        return context;
    }

    @Override
    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public Long getOwnerId() {
        return ownerId;
    }

    @Override
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String getRequestId() {
        return requestId;
    }

    @Override
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public Long getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getNonce() {
        return nonce;
    }

    @Override
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getSignature() {
        return signature;
    }

    @Override
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public Long getCreatorId() {
        return creatorId;
    }

    @Override
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Override
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public Long getModifierId() {
        return modifierId;
    }

    @Override
    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    @Override
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    @Override
    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public int hashCode() {
        return IdCapable.hashCode(this, super::hashCode);
    }

    @Override
    public boolean equals(Object obj) {
        return IdCapable.equals(this, obj);
    }
}
