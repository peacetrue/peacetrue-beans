package com.github.peacetrue.beans;

import com.github.peacetrue.beans.createmodify.CreateModify;
import com.github.peacetrue.beans.properties.clientid.ClientId;
import com.github.peacetrue.beans.properties.code.Code;
import com.github.peacetrue.beans.properties.context.Context;
import com.github.peacetrue.beans.properties.data.Data;
import com.github.peacetrue.beans.properties.deleted.Deleted;
import com.github.peacetrue.beans.properties.id.Id;
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

import java.time.LocalDateTime;

/**
 * @author peace
 **/
@Getter
@Setter
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
}
