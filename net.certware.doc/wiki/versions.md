# CertWare Version History

![CertWare Logo](certware-32.gif)

### Version 2.0.0

_Update_:
* Added OMG Structured Assurance Case Metamodel support, tree editor only without graphical editor. In general this model is rather too flat for graphical representation as is.  
* Added Fault Trees from Physics models, a fault tree generator producing accurate models from physical system descriptions.  
* Added a new language ```L``` for writing assurance and safety case arguments using semi-structured text while using an automated solver to check for consistency and completeness.  
* Added intent specification models based on Leveson's concepts.  
* Added a state analysis model based on the JPL state analysis model from the Mission Data System work.  
* Added a hazard mitigation model based on the Leveson STPA model, using a DSL for STPA formulated by CertWare.
* Added another simpler hazard analysis model for building alternatives.
* Added several examples to illustrate these new features.
* Migrated textile to markdown. 
* Brought these and all legacy features up to Mars.2 release.

### Version 1.2.3

_Update_:
* Updated copyright language per NASA legal direction.

_Commit_:
* Committed with ```1.2.3``` tag in reference branch ```M8```.

### Version 1.2.2

_Bugs Fixed_:

_Enhancements_:
* Modified Network Analysis view to make results section content dynamic according to analysis computation.  Combined the view's label and node columns to one, and added marginal probability column.  Modified certain calculations to produce the marginal values.
* Added sensitivity analysis to the inference view.  Uses both single-variable and multiple-variable combinations for analysis.  
* Updated copyright text.

_Commit_:
* Committed as reference branch ```M8``` with ```1.2.2``` tag.

### Version 1.2.1

_Bugs Fixed_:

_Enhancements_:
* Added checklist view with results editor, including editor linking, state mementi, model save, and export to Excel.  Added to CertWare perspective as view and shortcut.  
* Added preference values for semi-formal proof review wizard options.
* Added overlay splash handler for product version identification.
* Changed SAEM editor to single page.
* Updated Hugin NET DSL to handle all content of test networks.  
* Added Hugin Evidence metamodel to handle saving and restoring evidence instantiations from Hugin models in analysis view.
* Added Hugin network view with analysis support.  Uses associated preference page for calculation settings.  Analysis provided for maximum a posteriori (MAP) calculation using either exact (slow) or approximate (fast) methods.
* Added unit tests for various inference library usage scenarios.
* Added example contribution for Hugin NET DSL.

_Commit_:
* Committed as reference branch ```M7``` with ```1.2.1``` tag.


### Version 1.2.0

_Bugs Fixed_:
* Moved diagram preference page root into the CertWare preference page tree.
* Moved diagram new wizard category to the CertWare UI category.  

_Enhancements_:
* Added the SRI Structured Argument Markup Language (AML) model, and generated edit support and editors for arguments of this type. _There may be editor issues with the mixed XML element types in this generated code.  A number of elements did not generate properly and manual repair was required.  A bug report was filed for EEF._  A navigator contribution provides the explorer filter.
* Added the OMG Software Assurance Evidence Metamodel (SAEM) model, and generated edit support and editors for evidence of this type.  _It is not yet directly connected to the ARM derivatives for complete arguments._
* Added new file wizards for the CPN DSL, SFP DSL, GSN DSL, and Hugin NET DSL.  Added these to the CertWare perspective wizard shortcuts.
* Updated graphics images, icons, and splash page.   
* Provided initial universal welcome contribution when run as a product.
* Installed universal introduction contributions that merely point to the web site.
* Updated license language per NASA evaluation terms.

_Commit_:
* Committed as reference branch ```M6``` with ```1.2.0``` tag.

### Version 1.1.2

_Bugs Fixed_:
* Removed Xtext-generated new project wizards for GSN DSL and CPN DSL.  

_Enhancements_:
* Changed content property feature of ARM generator model to multi-line, thereby creating multi-line properties for CAE, EUR, and GSN tree-based model editors using text areas with scroll bars.  Updated corresponding EEF framework parts to text areas.  

### Version 1.1.1

_Bugs Fixed_:
* Gather change orders allows empty lists on sum calculators.
* Proof theorem detail page with empty ID now sets text properly.

### Version 1.1

_Bugs Fixed_:
* Reassigned diagram model creation wizard to CertWare new wizard category.
* Fixed labels on EUZ plugin identities and branding plug-in.
* Reassigned diagram preference pages to fall under the CertWare category.
* Added context and sub-strategy reference elements to the EUROCONTROL model strategy element.

_Enhancements_:
* Added API tooling setup to each project, adding nature and builder to support API report generation.  
* Expanded body text regions in all graphical shapes, allowing multi-line wrap display and editing.
* Expanded semi-formal proof support.  Added adapters for SFP outline view. Added active parser editor. Added validation for graph cycles and entailment. Added proof review wizard. Added dynamic help (first draft).  Added navigator contribution for SFP file types.
* Added planning module content for Microsoft Project MSPDI interchange model.
* Completed some string externalization.
* Updated to JGit 0.10.1 and EGit 0.10.1 for target platform and feature. Added these features to the CertWare parent.
* Added measurement model plugins.  The model is derived from the OMG Software Metrics Metamodel (1.0 beta 1, March 2009) XML schema, adopting and modifying an EMF implementation from Eclipse GMT MODISCO.
* Added CertWare Planning Notation (CPN) DSL for assigning planning data mapping onto ARM Metamodel.  Xtext project generated editor for DSL.  Validation included for editor content with markers.  Added a workbench view to show contents from workbench navigator or editor selections.  Added pop-up menu action to open selected resource in its view.  Added conversion action to translate the CPN file into Microsoft Project XML (MSPDI) file type for export.
* Added CertWare Software Project Metrics (SPM) EMF model for collecting and computing metrics on argument case artifacts in change sets.  Added corresponding navigator contribution summarized to the few key product and trend metrics with values.  Added example contribution fragment as a pattern for a fully-specified metrics model example with place-holder observations.  Added a workbench view to show contents from workbench navigator or editor selections.  Added pop-up menu action to open selected resource in its view.  Added object contribution action on selected project commit objects to compute change order count statistics from a selected change order (SCO) file.  Added object contribution action on selected project model or project commit objects to compute all metrics given the statistics in the model.  
* Added CertWare Software Change Order (SCO) EMF model for capturing change order records for metrics.  Added corresponding navigator contribution.  Added a workbench view to show contents from workbench navigator or editor selections.  Added pop-up menu action to open selected resource in its view.  Added an action to collect commit identifiers and file size history from a project's associated EGit repository, creating an SCO file in the project containing the results.  
* Added a CertWare workbench perspective.  Standard layout.  Added views and new-wizard perspective extensions from each plug-in.  Perspective defined in ```net.certware.core.ui``` plug-in.   
* Added a quick-and-dirty task hour accumulator to the task list, activated on the pop-up menu for task category containers.  Added a similar task hour accumulator to the project navigator for selections on a project container, which accumulates all hours for all tasks.  

_Commit_:
* Committed as reference branch ```M5``` with ```1.1.0``` tag.

### Version 1.0.2

_Bugs Fixed_:
* Fixed help context provider for example host plug-in.
* Added EVL feature as a sub-feature for the packaging.

_Enhancements_:
* Added CertWare category to diagram plug-in preference pages for improved navigation.
* Added help context IDs for details pages on the examples wizard.
* Added first draft of semi-formal proof editor, mapped to file extension ```.sfp```.  

_Commit_:
* Committed with ```1.0.2``` tag.

### Version 1.0.1

_Bugs Fixed_:
* Fixed example wizard's URL string matching for resource copying from fragment bundles.  This repair ensures the copying task is not dependent upon the extension point contribution's ordering of resources.  

_Enhancements_:
* None

_Commit_:
* Committed as reference branch ```M4``` with ```1.0.1``` tag.

### Version 1.0.0

_Enhancements_:
* Created ARM Ecore model for arguments, then GSN, CAE, and EUR Ecore models each depending on ARM package.
* Created VCL Ecore model for check lists.
* Established basic target definition including Equinox and RCP.  
* Established basic feature definition and branding support.
* Established basic extended editing properties sheets using EEF.  
* Created Apache POI plugin library package for POI 3.6.
* Created import/export plugin library package for docx4j.
* Included EGit/JGit support in run configuration.
* Unit test fragments created for ARM, GSN, and EUROCONTROL models.
* Navigator content contributions and filters for ARM, GSN, CAE, EUR, and VCL models.
* Example wizard using example resources contributed as fragments.
* Javadoc basic setup and Ant script saved.
* Graphical argument editors for CAE, GSN and EUROCONTROL models.

_Commit_:
* Committed as reference branch ```warr``` with ```1.0.0``` tag.
