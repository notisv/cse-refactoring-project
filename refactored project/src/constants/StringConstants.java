package constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringConstants {

	private StringConstants() {} 
	
	public static final List<String> NAMES_OF_COMMANDS = Arrays.asList(new String[] {
			"addLatex",
			"changeVersionsStrategy",
			"create",
			"disableVersionsManagement",
			"edit",
			"enableVersionsManagement",
			"load",
			"rollbackToPreviousVersion",
			"save"
	});
	
	public static final List<String> TEMPLATE_TYPES = Arrays.asList(new String[] {
			"articleTemplate",
			"bookTemplate",
			"letterTemplate",
			"reportTemplate",
			"emptyTemplate"
	});
	
	public static final Map<String, String> CONTENTS_OF_TYPE_TEMPLATE = Map.of(
			"articleTemplate", StringConstants.ARTICLE_TEMPLATE_CONTENT,
			"bookTemplate", StringConstants.BOOK_TEMPLATE_CONTENT ,
			"letterTemplate", StringConstants.LETTER_TEMPLATE_CONTENT ,
			"reportTemplate", StringConstants.REPORT_TEMPLATE_CONTENT ,
			"emptyTemplate" , StringConstants.EMPTY_TEMPLATE_CONTENT 
	);
	

	public static final String ARTICLE_TEMPLATE_CONTENT = "\\documentclass[11pt,twocolumn,a4paper]{article}\n\n"+

					"\\begin{document}\n"+
					"\\title{Article: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n\n"+

					"\\maketitle\n\n"+

					"\\Section{Section Title 1}\n\n"+

					"\\Section{Section Title 2}\n\n"+

					"\\Section{Section Title.....}\n\n"+

					"\\Section{Conclusion}\n\n"+

					"\\Section*{References}\n\n"+

					"\\end{document}\n";
	
	public static final String BOOK_TEMPLATE_CONTENT = "\\documentclass[11pt,a4paper]{book}\n\n"+

					"\\begin{document}\n"+
					"\\title{Book: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n\n"+

					"\\maketitle\n\n"+

					"\\frontmatter\n\n"+

					"\\chapter{Preface}\n"+
					"% ...\n\n"+

					"\\mainmatter\n"+
					"\\chapter{First chapter}\n"+
					"\\section{Section Title 1}\n"+
					"\\section{Section Title 2}\n\n"+

					"\\section{Section Title.....}\n\n"+

					"\\chapter{....}\n\n"+

					"\\chapter{Conclusion}\n\n"+

					"\\chapter*{References}\n\n\n"+


					"\\backmatter\n"+
					"\\chapter{Last note}\n\n"+

					"\\end{document}\n";
	
	public static final String LETTER_TEMPLATE_CONTENT = "\\documentclass{letter}\n"+
			
			"\\usepackage{hyperref}\n"+
			"\\signature{Sender's Name}\n"+
			"\\address{Sender's address...}\n"+
			"\\begin{document}\n\n"+

			"\\begin{letter}{Destination address....}\n"+
			"\\opening{Dear Sir or Madam:}\n\n"+

			"I am writing to you .......\n\n\n"+


			"\\closing{Yours Faithfully,}\n"+

			"\\ps\n\n"+

			"P.S. text .....\n\n"+

			"\\encl{Copyright permission form}\n\n"+

			"\\end{letter}\n"+
			"\\end{document}\n";
	
	public static final String REPORT_TEMPLATE_CONTENT = "\\documentclass[11pt,a4paper]{report}\n\n"+

					"\\begin{document}\n"+
					"\\title{Report Template: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n"+
					"\\maketitle\n\n"+

					"\\begin{abstract}\n"+
					"Your abstract goes here...\n"+
					"...\n"+
					"\\end{abstract}\n\n"+

					"\\chapter{Introduction}\n"+
					"\\section{Section Title 1}\n"+
					"\\section{Section Title 2}\n"+
					"\\section{Section Title.....}\n\n"+

					"\\chapter{....}\n\n"+

					"\\chapter{Conclusion}\n\n\n"+


					"\\chapter*{References}\n\n"+

					"\\end{document}\n";
	
	public static final String EMPTY_TEMPLATE_CONTENT = "" ;
	
	
	
	
	public static final Map<String, String> CONTENTS_OF_SUBTYPE_MAP = Map.of(
			"chapter", StringConstants.CHAPTER_CONTENT,
			"section", StringConstants.SECTION_CONTENT,
			"subsection",StringConstants.SUBSECTION_CONTENT,
			"subsubsection", StringConstants.SUBSUBSECTION_CONTENT,
			"enumerateConent", StringConstants.ENUMERATE_CONTENT,
			"itemizeContent",StringConstants.ITEMIZE_CONTENT,
			"tableConent", StringConstants.TABLE_CONTENT,
			"figureContent", StringConstants.FIGURE_CONTENT	
	);
	
	public static final String CHAPTER_CONTENT = "\n\\chapter{...}"+"\n" ;
	
	public static final String SECTION_CONTENT = "\n\\section{...}"+"\n" ;

	public static final String SUBSECTION_CONTENT = "\n\\subsection{...}"+"\n" ;
	
	public static final String SUBSUBSECTION_CONTENT = "\n\\subsubsection{...}"+"\n" ;
	
	public static final String ENUMERATE_CONTENT = "\\begin{enumerate}\n"+
			"\\item ...\n"+
			"\\item ...\n"+
			"\\end{enumerate}\n" ;
	
	
	public static final String ITEMIZE_CONTENT = "\\begin{itemize}\n"+
			"\\item ...\n"+
			"\\item ...\n"+
			"\\end{itemize}\n" ;
	
	
	public static final String TABLE_CONTENT = "\\begin{table}\n"+
			"\\caption{....}\\label{...}\n"+
			"\\begin{tabular}{|c|c|c|}\n"+
			"\\hline\n"+
			"... &...&...\\\\\n"+
			"... &...&...\\\\\n"+
			"... &...&...\\\\\n"+
			"\\hline\n"+
			"\\end{tabular}\n"+
			"\\end{table}\n" ;
	
	public static final String FIGURE_CONTENT = "\\begin{figure}\n"+
			"\\includegraphics[width=...,height=...]{...}\n"+
			"\\caption{....}\\label{...}\n"+
			"\\end{figure}\n" ;
	
	

	public static final String TITLE_HTML_TAG = "<title>" ;
	public static final String PARAGRAPH_HTML_TAG = "<p>" ;
	public static final String H1_HTML_TAG = "<h1>" ;
	public static final String H2_HTML_TAG = "<h2>" ;
	public static final String H3_HTML_TAG = "<h3>" ;
	public static final String H4_HTML_TAG = "<h4>" ;
	public static final String H5_HTML_TAG = "<h5>" ;
	public static final String H6_HTML_TAG = "<h6>" ;
	

	public static final Map<String, String> LATEX_TO_HTML_TAGS_MAP = new HashMap<String, String>() {{
		put("\\title", StringConstants.TITLE_HTML_TAG) ;
		put("\\author", StringConstants.H1_HTML_TAG);
		put("\\date", StringConstants.H2_HTML_TAG);
		put("\\chapter", StringConstants.H3_HTML_TAG);
		put("\\chapter*", StringConstants.H4_HTML_TAG);
		put("\\begin{document}", StringConstants.H5_HTML_TAG);
		put("\\end{document}", StringConstants.H6_HTML_TAG);
		put("\\section", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\begin{abstract}", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\end{abstract}", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\signature", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\address", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\begin{letter}", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\end{letter}", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\section*", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\closing", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\encl", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\Section", StringConstants.PARAGRAPH_HTML_TAG);
		put("\\Section*", StringConstants.PARAGRAPH_HTML_TAG);
	}};

	public static final List<String> SYMBOLS_AFTER_LATEX_TAG = Arrays.asList(new String[] {
			 "}{", 
			 "{" 
	});
	
	public static final String ARTICLE_TEMPLATE_START_CONTENT = "\\documentclass[11pt,twocolumn,a4paper]{article}" ;
	
	public static final String BOOK_TEMPLATE_START_CONTENT = "\\documentclass[11pt,a4paper]{book}" ;
	
	public static final String REPORT_TEMPLATE_START_CONTENT = "\\documentclass[11pt,a4paper]{report}" ;
	
	public static final String LETTER_TEMPLATE_START_CONTENT = "\\documentclass{letter}" ;
	
	public static final Map<String, String>  TEMPLATES_START_CONTENT_MAP = new HashMap<String, String>() {{
		put(StringConstants.ARTICLE_TEMPLATE_START_CONTENT , "articleTemplate") ;
		put(StringConstants.BOOK_TEMPLATE_START_CONTENT, "bookTemplate");
		put(StringConstants.REPORT_TEMPLATE_START_CONTENT, "reportTemplate");
		put(StringConstants.LETTER_TEMPLATE_START_CONTENT, "letterTemplate");
	}};
	
	public static final List<String> TEMPLATES_START_CONTENT_LIST = Arrays.asList(new String[] {
			ARTICLE_TEMPLATE_START_CONTENT,
			BOOK_TEMPLATE_START_CONTENT,
			REPORT_TEMPLATE_START_CONTENT,
			LETTER_TEMPLATE_START_CONTENT
	});
	
	
	
	/*
	 * 
	 * 
	 *  Constants For TESTING purposes
	 *  
	 *  
	 *  
	 */
	
	public static final String EDITED_ARTICLE_TEMPLATE_CONTENT = "\\documentclass[11pt,twocolumn,a4paper]{article}\n\n"+

					"\\KEYWORD{document}\n"+
					"\\title{Article: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n\n"+

					"\\maketitle\n\n"+

					"\\Section{Section Title 1}\n\n"+

					"\\Section{Section Title 2}\n\n"+

					"\\Section{Section Title.....}\n\n"+

					"\\Section{Conclusion}\n\n"+

					"\\Section*{References}\n\n"+

					"\\end{document}\n";
	
	
	public static final String EDITED_BOOK_TEMPLATE_CONTENT = "\\documentclass[11pt,a4paper]{book}\n\n"+

					"\\KEYWORD{document}\n"+
					"\\title{Book: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n\n"+

					"\\maketitle\n\n"+

					"\\frontmatter\n\n"+

					"\\chapter{Preface}\n"+
					"% ...\n\n"+

					"\\mainmatter\n"+
					"\\chapter{First chapter}\n"+
					"\\section{Section Title 1}\n"+
					"\\section{Section Title 2}\n\n"+

					"\\section{Section Title.....}\n\n"+

					"\\chapter{....}\n\n"+

					"\\chapter{Conclusion}\n\n"+

					"\\chapter*{References}\n\n\n"+


					"\\backmatter\n"+
					"\\chapter{Last note}\n\n"+

					"\\end{document}\n";
	
	public static final String EDITED_LETTER_TEMPLATE_CONTENT = "\\documentclass{letter}\n"+
			
			"\\usepackage{hyperref}\n"+
			"\\signature{Sender's Name}\n"+
			"\\address{Sender's address...}\n"+
			"\\KEYWORD{document}\n\n"+

			"\\KEYWORD{letter}{Destination address....}\n"+
			"\\opening{Dear Sir or Madam:}\n\n"+

			"I am writing to you .......\n\n\n"+


			"\\closing{Yours Faithfully,}\n"+

			"\\ps\n\n"+

			"P.S. text .....\n\n"+

			"\\encl{Copyright permission form}\n\n"+

			"\\end{letter}\n"+
			"\\end{document}\n";
	
	public static final String EDITED_REPORT_TEMPLATE_CONTENT = "\\documentclass[11pt,a4paper]{report}\n\n"+

					"\\KEYWORD{document}\n"+
					"\\title{Report Template: How to Structure a LaTeX Document}\n"+
					"\\author{Author1 \\and Author2 \\and ...}\n"+
					"\\date{\\today}\n"+
					"\\maketitle\n\n"+

					"\\KEYWORD{abstract}\n"+
					"Your abstract goes here...\n"+
					"...\n"+
					"\\end{abstract}\n\n"+

					"\\chapter{Introduction}\n"+
					"\\section{Section Title 1}\n"+
					"\\section{Section Title 2}\n"+
					"\\section{Section Title.....}\n\n"+

					"\\chapter{....}\n\n"+

					"\\chapter{Conclusion}\n\n\n"+


					"\\chapter*{References}\n\n"+

					"\\end{document}\n";
	
	public static final String EDITED_EMPTY_TEMPLATE_CONTENT = "" ;
	
	
	public static final Map<String, String> LATEX_TEMPLATE_TO_EDITED_CONTENT_MAP = new HashMap<String, String>() {{
		put("articleTemplate", EDITED_ARTICLE_TEMPLATE_CONTENT) ;
		put("bookTemplate", EDITED_BOOK_TEMPLATE_CONTENT) ;
		put("letterTemplate", EDITED_LETTER_TEMPLATE_CONTENT) ;
		put("reportTemplate", EDITED_REPORT_TEMPLATE_CONTENT);
		put("emptyTemplate", EDITED_EMPTY_TEMPLATE_CONTENT) ;
	}};

}
