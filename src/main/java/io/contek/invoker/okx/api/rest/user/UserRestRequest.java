package io.contek.invoker.okx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.okx.api.rest.RestRequest;
import io.contek.invoker.okx.api.rest.common.ResponseWrapper;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class UserRestRequest<T extends ResponseWrapper<?>> extends RestRequest<T> {

  UserRestRequest(IActor actor, RestContext context) {
    super(actor, context);
    if (actor.getCredential().isAnonymous()) {
      throw new IllegalArgumentException();
    }
  }
}
