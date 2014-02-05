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
import at.reppeitsolutions.formbuilder.components.html.HtmlIFrame;
import at.reppeitsolutions.formbuilder.components.html.renderer.formbuilder.FormFillerIFrameRenderer;
import javax.faces.component.FacesComponent;

/**
 *
 * @author Mathias Reppe <mathias.reppe@gmail.com>
 */
@FacesComponent(createTag = true, namespace = Constants.NAMESPACE, tagName = "formFillerIFrame")
public class FormFillerIFrame extends FormComponent {
    
    private HtmlIFrame iframe;
    
    public FormFillerIFrame() {
        setRendererType(FormFillerIFrameRenderer.RENDERTYPE);
        iframe = new HtmlIFrame();
        iframe.setStyle("width: 795px; height: 620px;");
        iframe.setBorder(0);
        iframe.setScrolling(false);
        getChildren().add(iframe);
    }
    
    public HtmlIFrame getIFrame() {
        return iframe;
    }
    
    public FormData getModel() {
        return (FormData) getStateHelper().eval("model");
    }

    public void setModel(FormData model) {
        getStateHelper().put("model", model);
    }

    @Override
    public String getFamily() {
        return FormFillerIFrameRenderer.FAMILY;
    }
    
}