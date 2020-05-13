package com.collabera.jump.fi;

public class MainPrintAscii {

	public static void main(String[] args) {
		
		PrintAscii asciiPrint  = () -> {
			System.out.println(
					" #####  ####### #       #          #    ######  ####### ######     #    \n" + 
					"#     # #     # #       #         # #   #     # #       #     #   # #   \n" + 
					"#       #     # #       #        #   #  #     # #       #     #  #   #  \n" + 
					"#       #     # #       #       #     # ######  #####   ######  #     # \n" + 
					"#       #     # #       #       ####### #     # #       #   #   ####### \n" + 
					"#     # #     # #       #       #     # #     # #       #    #  #     # \n" + 
					" #####  ####### ####### ####### #     # ######  ####### #     # #     # \n" + 
					"                                                                        \n" + 
					"");
		};
		
		
		asciiPrint.print();
		
		PrintAscii simplePrint  = () -> {
			System.out.println("Collabera");
		};
		
		simplePrint.print();
	}
}
