package com.github.peacetrue.beans.create;

import com.github.peacetrue.beans.operator.OperatorCapable;
import com.github.peacetrue.beans.properties.createdtime.CreatedTime;
import com.github.peacetrue.beans.properties.createdtime.CreatedTimeAware;
import com.github.peacetrue.beans.properties.creatorid.CreatorId;
import com.github.peacetrue.beans.properties.creatorid.CreatorIdAware;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author peace
 **/
public interface Create<T, S> extends
        CreateCapable<T, S>, CreateAware<T, S>,
        CreatorId<T>, CreatedTime<S> {

    static <S extends OperatorCapable<U>, T extends CreatorIdAware<U> & CreatedTimeAware<LocalDateTime>, U> T setCreateLocalDateTime(S source, T target) {
        return setCreate(source, target, LocalDateTime.now());
    }

    static <S extends OperatorCapable<U>, T extends CreatorIdAware<U> & CreatedTimeAware<Date>, U> T setCreateDate(S source, T target) {
        return setCreate(source, target, new Date());
    }

    static <S extends OperatorCapable<U>, T extends CreatorIdAware<U> & CreatedTimeAware<C>, U, C> T setCreate(S source, T target, C now) {
        target.setCreatorId(source.getOperatorId());
        target.setCreatedTime(now);
        return target;
    }

}
