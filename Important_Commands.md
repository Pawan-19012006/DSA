## Converting integer to string

Use String.valueOf(x)

ex) int x = 121; 
String s = String.valueOf(x);

now if i give, s.length() it will return 3, that is length of the number not the value

This works both for positive and negative values, ex) if i give, x = -121, s.length() it will return 4, that is length of the number including the negative sign

