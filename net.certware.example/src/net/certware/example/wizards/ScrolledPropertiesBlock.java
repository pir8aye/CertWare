package net.certware.example.wizards;

import net.certware.example.Activator;
import net.certware.example.Example;
import net.certware.example.ExampleCategory;
import net.certware.example.ExampleChecklist;
import net.certware.example.ExampleContributions;
import net.certware.example.ExampleDocument;
import net.certware.example.ExamplePattern;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.plugin.AbstractUIPlugin;


/**
 * A master-details block to show example candidates.
 * @author mrb
 * @since 1.0
 */
public class ScrolledPropertiesBlock extends MasterDetailsBlock {

	/** category image */
	static Image categoryImage = null;
	/** pattern image */
	static Image patternImage = null;
	/** document image */
	static Image documentImage = null;
	/** checklist image */
	static Image checklistImage = null;
	/** category image path */
	static final String CATEGORY_IMAGE = "icons/obj16/category.gif";
	/** pattern image path */
	static final String PATTERN_IMAGE = "icons/obj16/pattern.gif";
	/** document image path */
	static final String DOCUMENT_IMAGE = "icons/obj16/document.gif";
	/** checklist image path */
	static final String CHECKLIST_IMAGE = "icons/obj16/checklist.gif";
	/** horizontal layout image path */
	static final String HORIZONTAL_IMAGE = "icons/obj16/th_horizontal.gif";
	/** vertical layout image path */
	static final String VERTICAL_IMAGE = "icons/obj16/th_vertical.gif";
	/** example contributions for the trees */
	private ExampleContributions ec;

	/**
	 * Gets an image from the plugin.
	 * @param path path to image file
	 * @return image or null if descriptor not found
	 */
	private Image getImage(String path) {
		ImageDescriptor id = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, path);
		if ( id != null )
			return id.createImage();
		return null;
	}
	
	/**
	 * Creates the scrolled properties block.
	 * Creates the supporting images.
	 * @param ec contributions class
	 */
	public ScrolledPropertiesBlock(ExampleContributions ec) {
		categoryImage = getImage(CATEGORY_IMAGE);
		patternImage = getImage(PATTERN_IMAGE);
		documentImage = getImage(DOCUMENT_IMAGE);
		checklistImage = getImage(CHECKLIST_IMAGE);
		this.ec = ec;
	}

	/**
	 * Disposes of resources used by this block.
	 */
	public void dispose() {
		if ( categoryImage != null ) 
			categoryImage.dispose();
		if ( patternImage != null )
			patternImage.dispose();
		if ( documentImage != null )
			documentImage.dispose();
		if ( checklistImage != null )
			checklistImage.dispose();
	}

	/**
	 * Tree content provider.
	 * Contributions info as root, categories as branches, examples as leaves.
	 */
	class MasterContentProvider implements ITreeContentProvider 
	{
		public Object[] getElements(Object inputElement) {

			if (inputElement instanceof ExampleContributions) {
				ExampleContributions input = (ExampleContributions) inputElement;
				return input.getCategoriesArray();
			}
			
			if ( inputElement instanceof ExampleCategory ) {
				ExampleCategory input = (ExampleCategory) inputElement;
				return input.getExamplesArray();
			}

			return new Object[0];
		}

		/**
		 * Nothing to dispose.
		 */
		 public void dispose() {
		 }

		 /**
		  * Input changed for provider.  Unused.
		  */
		 public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		 }

		 /**
		  * Returns the children of the given parent object.
		  * @param parentElement parent object, either example contributions or example categories
		  * @return array of children for the parent, or null
		  */
		 public Object[] getChildren(Object parentElement)
		 {
			 if ( parentElement instanceof ExampleContributions ) {
				 return ((ExampleContributions)parentElement).getCategoriesArray();
			 }
			 
			 if ( parentElement instanceof ExampleCategory ) {
				 return ((ExampleCategory)parentElement).getExamplesArray();
			 }
			 
			 return null;
		 }

		 /**
		  * Returns the parent of the given element.  
		  * @param element child to find parent, supports category only
		  * @return container parent of the element (a category object), or null
		  */
		 public Object getParent(Object element)
		 {
			 if ( element instanceof ExampleCategory ) {
				 return ec;
			 }
			 
			 return null;
		 }

		 /**
		  * Whether the element has children.
		  * @param element to identify, either a SystemInfo or FileInfo
		  * @return true if element has non-empty children list, otherwise false
		  */
		 public boolean hasChildren(Object element)
		 {
			 if ( element instanceof ExampleContributions ) {
				 ExampleContributions si = (ExampleContributions)element;
				 if ( si.getCategories().isEmpty() == false )
					 return true;
			 }
			 
			 if ( element instanceof ExampleCategory ) {
				 ExampleCategory si = (ExampleCategory)element;
				 if ( si.getExamples().isEmpty() == false )
					 return true;
			 }

			 return false;
		 }
	}


	class MasterLabelProvider implements  ILabelProvider 
	{
		public String getText(Object obj) {

			if ( obj instanceof ExampleCategory ) {
				ExampleCategory c = (ExampleCategory)obj;
				return c.getName();
			}
			
			if ( obj instanceof Example ) {
				Example e = (Example)obj;
				return e.getName();
			}

			return obj.toString();
		}

		
		public Image getImage(Object obj) {

			if ( obj instanceof ExampleCategory ) {
				return categoryImage;
			}

			if ( obj instanceof ExampleDocument ) {
				return documentImage;
			}

			if ( obj instanceof ExamplePattern ) {
				return patternImage;
			}

			if ( obj instanceof ExampleChecklist ) {
				return checklistImage;
			}

			return null;
		}


		public void addListener(ILabelProviderListener listener)
		{
		}

		public void dispose()
		{
		}

		public boolean isLabelProperty(Object element, String property)
		{
			return false;
		}

		public void removeListener(ILabelProviderListener listener)
		{
		}
	}

	protected void createMasterPart(final IManagedForm managedForm, Composite parent) 
	{
		// final ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR );
		section.setText("Contributed Examples");
		section.setDescription("Select a category or example for details");
		section.marginWidth = 10;
		section.marginHeight = 5;
		toolkit.createCompositeSeparator(section);

		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		client.setLayout(layout);
		Tree t = toolkit.createTree(client, SWT.NULL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 300;
		gd.widthHint = 200;
		t.setLayoutData(gd);
		toolkit.paintBordersFor(client);
		section.setClient(client);

		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);

		TreeViewer viewer = new TreeViewer(t);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(spart, event.getSelection());
			}
		});

		viewer.setContentProvider(new MasterContentProvider());
		viewer.setLabelProvider(new MasterLabelProvider());
		viewer.setInput(ec);
		viewer.expandAll();
	}


	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();

		Action haction = new Action("hor", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText("Horizontal orientation");
		haction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,HORIZONTAL_IMAGE));

		Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) {
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("Vertical orientation");
		vaction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,VERTICAL_IMAGE));

		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
	}

	protected void registerPages(DetailsPart detailsPart) {
		// TODO do we need a category page?
		/*
		detailsPart.registerPage(ExamplePattern.class, new PatternExamplePage());
		detailsPart.registerPage(ExampleChecklist.class, new ChecklistExamplePage());
		detailsPart.registerPage(ExampleDocument.class, new DocumentExamplePage());
		*/
	}


}