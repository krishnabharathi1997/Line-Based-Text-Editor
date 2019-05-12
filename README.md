# LineBasedEditor

A Line Based text editor is one that allows manipulation of lines of simple text. This editor will support the following commands in order to enable a user to manipulate lines of text.
	
		Display contents (d) : On pressing the display contents shortcut (d), the application
		should print all the lines of the current file including the line numbers
		Display Specific lines (d.n.m) : Should show contents of line numbers n to m
		Insert line (i.n.<text>) : Insert the <text> at line number n
		Delete line (dd.n) : Delete line number n
		Delete lines (dd.n.m) : Delete lines from n to m
		Copy lines (yy.n.m) : Copy lines from line number n to m
		Paste (p.n) : Paste the clipboard contents at line number n
  		Undo (z) : Undo the last command
		Redo (zz) : Redo the last undone command
  
To run use: java -cp "jar-file" clear.editor 
