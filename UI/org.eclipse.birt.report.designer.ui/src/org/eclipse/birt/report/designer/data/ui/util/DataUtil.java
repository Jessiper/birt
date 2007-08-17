/*******************************************************************************
 * Copyright (c) 2004, 2007 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.designer.data.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.birt.core.data.ExpressionUtil;
import org.eclipse.birt.core.data.IColumnBinding;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.data.engine.api.IBinding;
import org.eclipse.birt.report.model.api.ComputedColumnHandle;

/**
 * This class provides various Data Engine Query utility methods for UI.
 */

public class DataUtil
{

	/**
	 * Return a list of valid group key bindings. Only those bindings that do not involve aggregations will be
	 * allowed.
	 * 
	 * @param availableHandles
	 * @return
	 */
	public static List getValidGroupKeyBindings( List availableHandles )
	{

		List result = new ArrayList( );
		if ( availableHandles == null )
			return result;
		try
		{
			for ( int i = 0; i < availableHandles.size( ); i++ )
			{
				ComputedColumnHandle handle = (ComputedColumnHandle) availableHandles.get( i );
				List originalNames = new ArrayList( );
				originalNames.add( handle.getName( ) );
				if ( acceptBinding( handle, availableHandles, originalNames ) )
					result.add( handle );
			}
		}
		catch ( Exception e )
		{
			return result;
		}

		return result;

	}

	/**
	 * 
	 * @param binding
	 * @param bindings
	 * @param originalNames
	 * @return
	 */
	private static boolean acceptBinding( ComputedColumnHandle binding,
			List bindings, List originalNames )
	{
		try
		{
			if ( binding.getAggregateFunction( ) == null )
			{
				String expr = binding.getExpression( );

				if ( !ExpressionUtil.hasAggregation( expr ) )
				{
					List referredBindings = ExpressionUtil.extractColumnExpressions( expr );
					List names = new ArrayList( );
					names.add( binding.getName( ) );
					names.addAll( originalNames );
					if ( acceptindirectReferredBindings( originalNames,
							bindings,
							referredBindings ) )
					{
						return true;
					}
				}

			}
		}
		catch ( BirtException e )
		{
		}
		return false;
	}

	/**
	 * 
	 * @param originalBindingName
	 * @param availableHandles
	 * @param referredBindings
	 * @return
	 */
	private static boolean acceptindirectReferredBindings(
			List originalBindingName, List availableHandles,
			List referredBindings )
	{
		try
		{
			List candidateBindings = new ArrayList( );
			for ( int i = 0; i < referredBindings.size( ); i++ )
			{
				IColumnBinding cb = (IColumnBinding) referredBindings.get( i );
				for ( int j = 0; j < availableHandles.size( ); j++ )
				{
					IBinding binding = (IBinding) availableHandles.get( j );
					if ( originalBindingName.contains( binding.getBindingName( ) ) )
						continue;
					if ( binding.getBindingName( )
							.equals( cb.getResultSetColumnName( ) ) )
						candidateBindings.add( binding );
				}
			}

			for ( int i = 0; i < candidateBindings.size( ); i++ )
			{
				ComputedColumnHandle handle = (ComputedColumnHandle) candidateBindings.get( i );
				if ( !acceptBinding( handle,
						availableHandles,
						originalBindingName ) )
					return false;
			}
			return true;
		}
		catch ( Exception e )
		{
			return false;
		}
	}
}
