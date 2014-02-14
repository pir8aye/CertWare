/**
 * Generated with Acceleo
 */
package net.certware.sacm.SACM.providers;

import net.certware.sacm.SACM.parts.SACMViewsRepository;

import net.certware.sacm.SACM.parts.forms.AnnotationPropertiesEditionPartForm;
import net.certware.sacm.SACM.parts.forms.AssuranceCasePropertiesEditionPartForm;
import net.certware.sacm.SACM.parts.forms.DatetimePropertiesEditionPartForm;
import net.certware.sacm.SACM.parts.forms.TaggedValuePropertiesEditionPartForm;

import net.certware.sacm.SACM.parts.impl.AnnotationPropertiesEditionPartImpl;
import net.certware.sacm.SACM.parts.impl.AssuranceCasePropertiesEditionPartImpl;
import net.certware.sacm.SACM.parts.impl.DatetimePropertiesEditionPartImpl;
import net.certware.sacm.SACM.parts.impl.TaggedValuePropertiesEditionPartImpl;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

/**
 * 
 * 
 */
public class SACMPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == SACMViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == SACMViewsRepository.Annotation.class) {
			if (kind == SACMViewsRepository.SWT_KIND)
				return new AnnotationPropertiesEditionPartImpl(component);
			if (kind == SACMViewsRepository.FORM_KIND)
				return new AnnotationPropertiesEditionPartForm(component);
		}
		if (key == SACMViewsRepository.AssuranceCase.class) {
			if (kind == SACMViewsRepository.SWT_KIND)
				return new AssuranceCasePropertiesEditionPartImpl(component);
			if (kind == SACMViewsRepository.FORM_KIND)
				return new AssuranceCasePropertiesEditionPartForm(component);
		}
		if (key == SACMViewsRepository.Datetime.class) {
			if (kind == SACMViewsRepository.SWT_KIND)
				return new DatetimePropertiesEditionPartImpl(component);
			if (kind == SACMViewsRepository.FORM_KIND)
				return new DatetimePropertiesEditionPartForm(component);
		}
		if (key == SACMViewsRepository.TaggedValue.class) {
			if (kind == SACMViewsRepository.SWT_KIND)
				return new TaggedValuePropertiesEditionPartImpl(component);
			if (kind == SACMViewsRepository.FORM_KIND)
				return new TaggedValuePropertiesEditionPartForm(component);
		}
		return null;
	}

}