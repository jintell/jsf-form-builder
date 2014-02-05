/*
 * Copyright (C) 2014 Mathias Reppe <mathias.reppe@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package at.reppeitsolutions.formbuilder.components;

import at.reppeitsolutions.formbuilder.components.formbuilderitem.data.FormData;
import at.reppeitsolutions.formbuilder.model.Form;
import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
@ManagedBean
@ViewScoped
public class ModelViewBean implements Serializable {

    private String uuid;
    ModelApplicationBean modelApplicationBean;
    
    public ModelViewBean() {
        
    }
    
    @PreDestroy
    public void preDestroy() {
        getModelApplicationBean().destroyModel(uuid);
        getModelApplicationBean().destroyModelData(uuid);
    }
    
    public Form getModel() {
        return getModelApplicationBean().getModel(uuid);
    } 
    
    //Just for ide to restore session after deploy
    private void setModel(Form form) {
        getModelApplicationBean().putModel(uuid, form);
    }
    
    public FormData getModelData() {
        return getModelApplicationBean().getModelData(uuid);
    }
    
    //Just for ide to restore session after deploy
    private void setModelData(FormData formdata) {
        getModelApplicationBean().putModelData(uuid, formdata);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ModelApplicationBean getModelApplicationBean() {
        if(modelApplicationBean == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            modelApplicationBean = (ModelApplicationBean) ctx.getApplication().evaluateExpressionGet(ctx, "#{modelApplicationBean}", ModelApplicationBean.class);
        }
        return modelApplicationBean;
    }

    public void setModelApplicationBean(ModelApplicationBean modelApplicationBean) {
        this.modelApplicationBean = modelApplicationBean;
    }
    
}