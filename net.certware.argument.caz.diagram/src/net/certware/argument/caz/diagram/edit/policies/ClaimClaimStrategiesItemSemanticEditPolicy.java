package net.certware.argument.caz.diagram.edit.policies;

import net.certware.argument.caz.diagram.providers.CazElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class ClaimClaimStrategiesItemSemanticEditPolicy extends
		CazBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClaimClaimStrategiesItemSemanticEditPolicy() {
		super(CazElementTypes.ClaimClaimStrategies_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
