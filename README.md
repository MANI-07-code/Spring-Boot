csrf - cross site request forgery

It is a security attack where an attacker tricks a user who is already logged in to a website into performing an unwanted action without their knowledge.

CSRF protection is generally not needed for GET requests, provided that GET is used only to read data and does not change the application's state.

HTTP         method	Purpose	               CSRF protection
GET	         Read data	Generally          not required
POST	       Create or submit data	       Usually required
PUT	         Update data	                 Usually required
PATCH	       Partially update data	       Usually required
DELETE	     Delete data	                 Usually required

HTTP by default stateless - so we have session id that the browser remember us

Spring Security can protect against CSRF by requiring a valid CSRF token with requests that change data.
Think of the token as an extra security check.
1. The server generates a CSRF token.
2. The legitimate application receives the token.
3. When submitting a state-changing request, the application sends the token along with the request.
4. Spring Security validates the token. If it is missing or invalid, the request is rejected.

for POST 
IN Headers
   key : X-CSRF-TOKEN

   get token from HttpServletRequest where reuest.getArribute("_csrf);
