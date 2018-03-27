# Mobile Challenge

**Project Description**

As  a  mobile  engineer  you've  been  tasked  with  the  development  of  an  app  for  beer  lovers.  This  first  version  (MVP)  of the  app  will  be  very  simple  and  limited  to  only  show  the  list  of  products  and  that  the  user  can  buy  in  an  e-store.  The app  will  be  fed  with  content  from  a  Test  Database  of  Courier  DB  (Credentials  will  be  shown  later).  The  platform  you should  use  should  choose  between  Android,  iOS  or  React  Native.

FUNCTIONAL  REQUIREMENTS

The  first  release  of  the  app  will  be  very  limited  in  scope,  but  will  serve  as  the  foundation  for  future  releases.  You're going  to  develop  now  basically  3  screens:

●  Home  -  Where  the  user  needs  to  input  his  address,  to  find  the  localization  (lat,lng)  needed  to  find  the  POC (Point  of  contact)  where  you're  going  to  get  the  list  of  the  products.  
●  Product  List  -  Where  the  user  will  get  the  categories  list  from  the  service  and  change  the  list  according  to the  selected  category.
●  Product  Detail  -  Where  the  user  will  see  some  details  of  the  products.

TECHNICAL  REQUIREMENTS

You  should  see  this  project  as  an  opportunity  to  create  an  app  following  modern  development  best  practices  (given your  platform  of  choice),  but  also  feel  free  to  use  your  own  app  architecture  preferences  (coding  standards,  code organization,  third-party  libraries,  etc).

We're  using  GraphQL:  https://www.graphql.com/guides/ Here  are  some  specifications  about  the  APIs  used:

The  API  link  is:  https://803votn6w7.execute-api.us-west-2.amazonaws.com/dev/public/graphql

- Home  
	- To  find  the  latitude  and  longitude  of  an  address,  please  use  a  google  maps  API.

■ Use  the  following  address  to  find  a  POC:  Rua  Américo  Brasiliense,  São  Paulo  . ○ The  Query  needed  to  get  the  right  POC  (Get  the  first  POC):

-   Query:  http://bit.ly/2uSIRPz
    
-   Arguments:
    
    -  Algorithm:  "NEAREST".
        
    -  Lat:  Use  as  String.
        
    -   Long:  Use  as  String.
        
    -  Now:  Pass  the  current  Date  formatted.
        

● Product  List

-   The  Query  needed  to  get  the  products
    
    -   Query:  http://bit.ly/2vSpmqK
        
    -   Arguments:
        
        -   Id:  id  of  the  POC.
            
        -    Search:  if  ""  (empty),  do  not  filters  by  search.
            
        -    CategoryId:  if  0  (Zero)  do  not  filters  by  category.
            
-   The  Query  needed  to  get  the  category  list
    

■ Query:  http://bit.ly/2ugVEYE
Feel  free  to  use  package/dependency  managers  (ex:  Maven,  CocoaPods,  npm,  etc)  if  you  see  fit.


DELIVERABLES

The  project  source  code  and  dependencies  should  be  made  available  in  GitHub.  Here  are  the  steps  you  should follow:

1.  Create  a  public  repository  on  GitHub  (create  an  account  if  you  don't  have  one).  
2.  Create  a  "development"  branch  and  commit  the  code  to  it.  Do  not  push  the  code  to  the  master  branch.  3.  Create  a "screenshots"  sub-folder  and  include  at  least  two  screenshots  of  the  app.  
4.  Include  a  README  file  that  describes:

●  Special  build  instructions,  if  any  
●  List  of  third-party  libraries  used  and  short  description  of  why/how  they  were  used  5.  Once  the  work  is complete,  create  a  pull  request  and  send  us  the  link.


NOTES

Here  at  Zx  Ventures  we're  big  believers  of  collective  code  ownership,  so  remember  that  you're  writing  code  that  will be  reviewed,  tested,  maintained  by  other  developers.  Things  to  keep  in  mind:

●  First  of  all,  it  should  compile  and  run  without  errors  
●  Be  as  clean  and  consistent  as  possible  
●  Despite  the  project  simplicity,  don't  ignore  development  and  architecture  best  practices.  It's expected  that  code  architecture  will  be  structured  to  support  project  growth.

This  project  description  is  intentionally  vague  in  some  aspects,  but  if  you  need  assistance  feel  free  to  ask  for  help.  We wish  you  good  luck!
