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

package org.eclipse.birt.report;

import org.eclipse.birt.report.engine.api.HTMLRenderOption;

public interface IBirtConstants
{

	// Oprand Name Value pair: Names
	public static final String OPRAND_PAGENO = "__page"; //$NON-NLS-1$
	public static final String OPRAND_BOOKMARK = "__bookmark"; //$NON-NLS-1$	
	public static final String OPRAND_SVG = "__svg"; //$NON-NLS-1$
	public static final String OPRAND_TASKID = "__taskid"; //$NON-NLS-1$
	public static final String OPRAND_ISTOC = "__istoc"; //$NON-NLS-1$
	public static final String OPRAND_PARAM = "param"; //$NON-NLS-1$
	
	public static final String MIME_TYPE = "text/xml"; //$NON-NLS-1$
	public static final String HTML_RENDER_FORMAT = HTMLRenderOption.OUTPUT_FORMAT_HTML;
	public static final String PDF_RENDER_FORMAT = HTMLRenderOption.OUTPUT_FORMAT_PDF;
	public static final String POSTSCRIPT_RENDER_FORMAT = "postscript"; //$NON-NLS-1$
	public static final String DOC_RENDER_FORMAT = "doc"; //$NON-NLS-1$
	public static final String EXCEL_RENDER_FORMAT = "xls"; //$NON-NLS-1$
	public static final String PPT_RENDER_FORMAT = "ppt"; //$NON-NLS-1$
	
	// frameset viewer model.
	public static final String VIEWER_FRAMESET = "frameset"; //$NON-NLS-1$

	// run viewer model.
	public static final String VIEWER_RUN = "run"; //$NON-NLS-1$
	
	// preview viewer model.
	public static final String VIEWER_PREVIEW = "preview"; //$NON-NLS-1$

	// parameter viewer model.
	public static final String VIEWER_PARAMETER = "parameter"; //$NON-NLS-1$

	// document viewer model.
	public static final String VIEWER_DOCUMENT = "document"; //$NON-NLS-1$

	// output viewer model.
	public static final String VIEWER_OUTPUT = "output"; //$NON-NLS-1$
	
	// Servlet path for frameset model.
	public static final String SERVLET_PATH_FRAMESET = "/" + VIEWER_FRAMESET; //$NON-NLS-1$

	// Servlet path for running model.
	public static final String SERVLET_PATH_RUN = "/" + VIEWER_RUN; //$NON-NLS-1$

	// Servlet path for preview model.
	public static final String SERVLET_PATH_PREVIEW = "/" + VIEWER_PREVIEW; //$NON-NLS-1$

	// Servlet path for parameter model.
	public static final String SERVLET_PATH_PARAMETER = "/" + VIEWER_PARAMETER; //$NON-NLS-1$

	// Servlet path for document model.
	public static final String SERVLET_PATH_DOCUMENT = "/" + VIEWER_DOCUMENT; //$NON-NLS-1$

	// Servlet path for output model.
	public static final String SERVLET_PATH_OUTPUT = "/" + VIEWER_OUTPUT; //$NON-NLS-1$

	// Servlet path for download model.
	public static final String SERVLET_PATH_DOWNLOAD = "/download"; //$NON-NLS-1$

	// request GET method.
	public static final String REQUEST_GET = "get"; //$NON-NLS-1$

	// request POST method.
	public static final String REQUEST_POST = "post"; //$NON-NLS-1$

	// suffix of design file
	public static final String SUFFIX_DESIGN_FILE = "rptdesign"; //$NON-NLS-1$

	// suffix of template file
	public static final String SUFFIX_TEMPLATE_FILE = "rpttemplate"; //$NON-NLS-1$

	// suffix of library file
	public static final String SUFFIX_LIBRARY_FILE = "rptlibrary"; //$NON-NLS-1$

	// suffix of design document file
	public static final String SUFFIX_DESIGN_DOCUMENT = "rptdocument"; //$NON-NLS-1$

	// suffix of design config file
	public static final String SUFFIX_DESIGN_CONFIG = "rptconfig"; //$NON-NLS-1$
	
	// Attribute Bean
	public static final String ATTRIBUTE_BEAN = "attributeBean"; //$NON-NLS-1$
	
	// If Cascade parameter
	public static final String IS_CASCADE = "isCascade"; //$NON-NLS-1$
	
	// Property -- type
	public static final String PROP_TYPE = "type"; //$NON-NLS-1$
	
	// Property -- value expression
	public static final String PROP_EXPR = "expr"; //$NON-NLS-1$	
	
	// Task Map
	public static final String TASK_MAP = "tasks"; //$NON-NLS-1$
	
	// default value of viewer settings
	public static final String DEFAULT_VIEWER_CONFIG_FILE = "WEB-INF/viewer.properties"; //$NON-NLS-1$
	public static final String DEFAULT_DOCUMENT_FOLDER = "documents";//$NON-NLS-1$
	public static final String DEFAULT_IMAGE_FOLDER = "report/images"; //$NON-NLS-1$
	public static final String DEFAULT_LOGS_FOLDER = "logs"; //$NON-NLS-1$
	public static final String DEFAULT_LOGS_LEVEL = "WARNING"; //$NON-NLS-1$
	public static final String DEFAULT_SCRIPTLIB_FOLDER = "scriptlib"; //$NON-NLS-1$	
	
	// Open type
	public static final String OPEN_TYPE_INLINE = "inline"; //$NON-NLS-1$
	public static final String OPEN_TYPE_ATTACHMENT = "attachment"; //$NON-NLS-1$
	
	// Action name
	public static final String ACTION_PRINT = "print"; //$NON-NLS-1$
	
	// Message type
	public static final String MSG_ERROR = "error"; //$NON-NLS-1$
	public static final String MSG_COMPLETE = "complete"; //$NON-NLS-1$
	
	// Flag
	public static final String VAR_ON = "ON"; //$NON-NLS-1$
	public static final String VAR_OFF = "OFF"; //$NON-NLS-1$
	
	// Null Value
	public static final String NULL_VALUE = "Null Value"; //$NON-NLS-1$
	
	// System property name
	public static final String SYS_PROP_WORKING_PATH = "birt.viewer.working.path"; //$NON-NLS-1$
	public static final String SYS_PROP_RESOURCE_PATH = "birt.viewer.resource.path"; //$NON-NLS-1$
	public static final String SYS_PROP_ROOT_PATH = "birt.viewer.root.path"; //$NON-NLS-1$
	public static final String SYS_PROP_BIRT_ISDESIGNER = "birt.designer"; //$NON-NLS-1$

	/**
	 * unknown line number
	 */
	public static final int UNKNOWN_POSITION = -1;
}