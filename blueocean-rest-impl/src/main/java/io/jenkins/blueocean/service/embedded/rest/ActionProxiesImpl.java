package io.jenkins.blueocean.service.embedded.rest;

import hudson.model.Action;
import io.jenkins.blueocean.rest.hal.Link;
import io.jenkins.blueocean.rest.model.BlueActionProxy;
import io.jenkins.blueocean.rest.model.Resource;

/**
 * @author Vivek Pandey
 */
public class ActionProxiesImpl extends BlueActionProxy {

    private final Action action;
    private final Resource parent;
    public ActionProxiesImpl(Action action, Resource parent) {
        this.action = action;
        this.parent = parent;
    }


    @Override
    public Object getAction() {
        return action;
    }

    @Override
    public String getUrlName() {
        return action.getUrlName();
    }

    @Override
    public String get_Class() {
        return action.getClass().getName();
    }

    @Override
    public Link getLink() {
        if(getUrlName() != null) {
            return new Link(parent.getLink().getHref().concat(getUrlName()));
        }
        return null;
    }
}