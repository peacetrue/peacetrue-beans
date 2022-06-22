package com.github.peacetrue.beans.createmodify;

import com.github.peacetrue.beans.create.Create;
import com.github.peacetrue.beans.modify.Modify;
import com.github.peacetrue.beans.operator.OperatorCapable;
import com.github.peacetrue.beans.properties.createdtime.CreatedTimeAware;
import com.github.peacetrue.beans.properties.creatorid.CreatorIdAware;
import com.github.peacetrue.beans.properties.modifiedtime.ModifiedTimeAware;
import com.github.peacetrue.beans.properties.modifierid.ModifierIdAware;

/**
 * @author peace
 **/
public interface CreateModify<T, S> extends
        CreateModifyCapable<T, S>, CreateModifyAware<T, S>,
        Create<T, S>, Modify<T, S> {

    static <S extends OperatorCapable<U>, T extends CreatorIdAware<U> & CreatedTimeAware<C> & ModifierIdAware<U> & ModifiedTimeAware<C>, U, C> T setCreateModify(S source, T target, C now) {
        Modify.setModify(source, target, now);
        return Create.setCreate(source, target, now);
    }

}
