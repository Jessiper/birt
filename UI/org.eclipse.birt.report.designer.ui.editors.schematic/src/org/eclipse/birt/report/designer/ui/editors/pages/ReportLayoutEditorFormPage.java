/*************************************************************************************
 * Copyright (c) 2004 Actuate Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Actuate Corporation - Initial implementation.
 ************************************************************************************/

package org.eclipse.birt.report.designer.ui.editors.pages;

import org.eclipse.birt.report.designer.core.model.SessionHandleAdapter;
import org.eclipse.birt.report.designer.internal.ui.command.WrapperCommandStack;
import org.eclipse.birt.report.designer.internal.ui.editors.schematic.layout.ReportLayoutEditor;
import org.eclipse.birt.report.designer.internal.ui.views.data.DataViewPage;
import org.eclipse.birt.report.designer.internal.ui.views.data.DataViewTreeViewerPage;
import org.eclipse.birt.report.designer.ui.editors.IPageStaleType;
import org.eclipse.birt.report.designer.ui.editors.IReportEditorPage;
import org.eclipse.birt.report.designer.ui.editors.IReportProvider;
import org.eclipse.birt.report.designer.ui.editors.MultiPageReportEditor;
import org.eclipse.birt.report.model.api.ModuleHandle;
import org.eclipse.birt.report.model.api.activity.ActivityStackEvent;
import org.eclipse.birt.report.model.api.activity.ActivityStackListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;

/**
 * Report layout page is the graphical editor for report layout.
 */
public class ReportLayoutEditorFormPage extends ReportLayoutEditor
		implements
			IReportEditorPage
{

	public static final String ID = MultiPageReportEditor.LayoutEditor_ID; //$NON-NLS-1$

	private int index;

	private FormEditor editor;

	private Control control;

	private int staleType;

	private DataViewTreeViewerPage dataViewPage;

	private ActivityStackListener commandStackListener = new ActivityStackListener( ) {

		public void stackChanged( ActivityStackEvent event )
		{
			updateStackActions( );
			getEditor( ).editorDirtyStateChanged( );
			staleType = IPageStaleType.MODEL_CHANGED;
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.ui.editors.schematic.layout.AbstractReportGraphicalEditorWithRuler#configureGraphicalViewer()
	 */
	protected void configureGraphicalViewer( )
	{
		super.configureGraphicalViewer( );
		WrapperCommandStack stack = (WrapperCommandStack) getCommandStack( );
		if ( stack != null )
		{
			stack.addCommandStackListener( getCommandStackListener( ) );
		}
	}

	/**
	 * returns command stack listener.
	 */
	public ActivityStackListener getCommandStackListener( )
	{
		return commandStackListener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#initialize(org.eclipse.ui.forms.editor.FormEditor)
	 */
	public void initialize( FormEditor editor )
	{
		this.editor = editor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#getEditor()
	 */
	public FormEditor getEditor( )
	{
		return editor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#getManagedForm()
	 */
	public IManagedForm getManagedForm( )
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#setActive(boolean)
	 */
	public void setActive( boolean active )
	{
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#isActive()
	 */
	public boolean isActive( )
	{
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#canLeaveThePage()
	 */
	public boolean canLeaveThePage( )
	{
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#getPartControl()
	 */
	public Control getPartControl( )
	{
		return control;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#getId()
	 */
	public String getId( )
	{
		return ID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#getIndex()
	 */
	public int getIndex( )
	{
		return index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#setIndex(int)
	 */
	public void setIndex( int index )
	{
		this.index = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#isEditor()
	 */
	public boolean isEditor( )
	{
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.IFormPage#selectReveal(java.lang.Object)
	 */
	public boolean selectReveal( Object object )
	{
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl( Composite parent )
	{
		super.createPartControl( parent );
		Control[] children = parent.getChildren( );
		control = children[children.length - 1];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.ui.editors.schematic.layout.AbstractReportGraphicalEditorWithRuler#dispose()
	 */
	public void dispose( )
	{

		if ( getCommandStack( ) != null )
		{
			WrapperCommandStack stack = (WrapperCommandStack) getCommandStack( );
			stack.removeCommandStackListener( getCommandStackListener( ) );
		}
		super.dispose( );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.ui.editors.IReportEditorPage#markPageStale(int)
	 */
	public void markPageStale( int type )
	{
		staleType = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.ui.editors.IReportEditorPage#getStaleType()
	 */
	public int getStaleType( )
	{
		return staleType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.ui.editors.schematic.layout.ReportLayoutEditor#getAdapter(java.lang.Class)
	 */
	public Object getAdapter( Class adapter )
	{
		if ( adapter == DataViewPage.class )
		{
			if ( dataViewPage == null )
			{
				dataViewPage = new DataViewTreeViewerPage( getModel( ) );
			}
			return dataViewPage;
		}
		return super.getAdapter( adapter );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.ui.editors.IReportEditorPage#onBroughtToTop(org.eclipse.birt.report.designer.ui.editors.IReportEditorPage)
	 */
	public boolean onBroughtToTop( IReportEditorPage prePage )
	{
		if ( getEditorInput( ) != prePage.getEditorInput( ) )
		{
			setInput( prePage.getEditorInput( ) );
		}
		ModuleHandle model = getProvider( ).getReportModuleHandle( getEditorInput( ) );
		
		if ( model != null && getModel( ) != model )
		{
			Object oldModel = getModel( );

			setModel( model );
			
			rebuildReportDesign( oldModel );
			if ( getModel( ) != null )
			{
				this.getGraphicalViewer( ).setContents( getModel( ) );
				markPageStale( IPageStaleType.NONE );
			}
			updateStackActions( );
		}

		return true;
	}

	/**
	 * Rebuild report design model.
	 * 
	 * @param oldModel
	 */
	protected void rebuildReportDesign( Object oldModel )
	{
		// Initializes command stack
		WrapperCommandStack stack = (WrapperCommandStack) getCommandStack( );
		if ( stack != null )
		{
			stack.removeCommandStackListener( getCommandStackListener( ) );
			stack.setActivityStack( getModel( ).getCommandStack( ) );
			stack.addCommandStackListener( getCommandStackListener( ) );
		}

		// Resets the mediator
		SessionHandleAdapter.getInstance( ).resetReportDesign( oldModel,
				getModel( ) );

		SessionHandleAdapter.getInstance( ).setReportDesignHandle(
				getProvider( ).getReportModuleHandle( getEditorInput( ) ) );

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#firePropertyChange(int)
	 */
	protected void firePropertyChange( int type )
	{
		if ( type == PROP_DIRTY )
		{
			editor.editorDirtyStateChanged( );
		}
		else
			super.firePropertyChange( type );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
	 */
	public void setInput( IEditorInput input )
	{
		super.setInput( input );
	}

	protected IReportProvider getProvider( )
	{
		IReportProvider provider =  (IReportProvider) editor.getAdapter( IReportProvider.class );
		if(provider == null)
		{
			provider = super.getProvider( );
		}
		
		return provider;
	}
}
