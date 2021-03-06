package net.certware.argument.sfp.review.preferences;

import net.certware.argument.sfp.review.Activator;
import net.certware.core.ui.CertWareUI;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for checklist view property processing.
 * @author mrb
 * @since 1.2.1
 */
public class SfpReviewPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Constructor creates the grid and description.
	 */
	public SfpReviewPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Semi-Formal Proof Review Preferences");
		this.setImageDescriptor( CertWareUI.getDefault().getImageRegistry().getDescriptor(CertWareUI.PREFERENCES_IMAGE));
	}

	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		/*
		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, 
				"&Directory preference:", getFieldEditorParent()));

		addField(new RadioGroupFieldEditor(
				PreferenceConstants.P_CHOICE,
			"An example of a multiple-choice preference",
			1,
			new String[][] { { "&Choice 1", "choice1" }, {
				"C&hoice 2", "choice2" }
		}, getFieldEditorParent()));
        addField(
            new StringFieldEditor(PreferenceConstants.P_STRING, "A &text preference:", getFieldEditorParent()));
		 */
		/*
      addField(
        new ColorFieldEditor(PreferenceConstants.P_LABEL_DECORATOR_FOREGROUND,
          "Label decorator &foreground:",
          getFieldEditorParent()));

      addField(
        new StringFieldEditor(PreferenceConstants.P_LABEL_DECORATOR_SUFFIX, 
          "Label decorator &suffix:", getFieldEditorParent()));
		 */

		addField(
				new BooleanFieldEditor(PreferenceConstants.P_SHOW_PREMISE_VALIDITY,
						"Whether to show &premise validity states during review",
						getFieldEditorParent()));

		addField(
				new StringFieldEditor(PreferenceConstants.P_ITEM_VALID_LABEL,
						"Label for '&valid' or 'sound' inferences:",
						getFieldEditorParent()));

		addField(
				new StringFieldEditor(PreferenceConstants.P_ITEM_INVALID_LABEL,
						"Label for '&invalid' or 'unsound' inferences:",
						getFieldEditorParent()));

		addField(
				new StringFieldEditor(PreferenceConstants.P_ITEM_UNKNOWN_LABEL,
						"Label for 'unknown' inferences:",
						getFieldEditorParent()));

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}