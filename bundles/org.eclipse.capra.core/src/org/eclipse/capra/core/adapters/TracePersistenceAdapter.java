/*******************************************************************************
 * Copyright (c) 2016, 2019 Chalmers | University of Gothenburg, rt-labs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *      Chalmers | University of Gothenburg and rt-labs - initial API and implementation and/or initial documentation
 *      Chalmers | University of Gothenburg - additional features, updated API
 *******************************************************************************/
package org.eclipse.capra.core.adapters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * This interface defines all functionality used to decide how and where the
 * trace model and all artifact wrappers are persisted.
 * 
 * @author Anthony Anjorin, Salome Maro
 *
 */
public interface TracePersistenceAdapter {

	/**
	 * Load and return the trace model in the given resource set
	 * 
	 * @param resourceSet Resource set to load the trace model in
	 * @return Root of loaded trace model, Optional can be empty to indicate that
	 *         loading failed or was not possible (there is no trace model to load
	 *         at the moment)
	 */
	EObject getTraceModel(ResourceSet resourceSet);

	/**
	 * Load and return the container for all artifact wrappers in the given resource
	 * set
	 * 
	 * @param resourceSet Resource set to load the container for artifact wrappers
	 *                    in
	 * @return Container for all artifact wrappers, Optional can be empty to
	 *         indicate that loading failed or was not possible (no container exists
	 *         at the moment)
	 */
	EObject getArtifactWrappers(ResourceSet resourceSet);

	/**
	 * Save the trace and artifact models. Implementations are expected to: (i) save
	 * the trace model, (ii) check selectionForTraceCreation for artifact wrappers
	 * that are not already contained in artifactWrappers, (iii) add these new
	 * artifact wrappers to artifactWrappers before saving it as well
	 * 
	 * @param traceModel    The updated trace model to be saved
	 * @param artifactModel The updated artifacts to be saved
	 */
	void saveTracesAndArtifacts(EObject traceModel, EObject artifactModel);
}
