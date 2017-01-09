package controllers


import play.api.mvc.{Controller, Action}

class CalcController extends Controller {

  /**
    * Create an action called `add`
    * accept two integers extracted from the URL
    * ADD them together
    * return a plain text HTTP 200 response containing the result
    */

  def add(a: Int, b: Int) = Action { result =>
    Ok(s"$a + $b = ${a + b}")
  }

  /**
    * Create an action called `add`
    * accept two booleans extracted from the URL;
    * AND them together;
    * return a plain text HTTP 200 response containing the result.
    */
  def and(a: Boolean, b: Boolean) = Action { result =>
    Ok(s"a && b = ${a && b}")
  }

  /**
    * Create an action called `concat`
    * accept a rest argument extracted from the URL;
    * concatenate the URL-decoded path fragments from the argument,
    * effectively removing slashes from the text;
    * return a plain text HTTP 200 response containing the result.
    * TIP: Use the `urlDecode` helper method if you need to to decode
    */
  def concat(args: String) = Action { result =>
    Ok(args.split("/").mkString(""))
  }

  /**
    * Create an action called `sort`
    * accept a list of integers extracted from the URL
    * sort the list;
    * return a space separated plain text HTTP 200 response of the result.
    */
  def sort(a: List[Int]) = Action { result =>
//    Ok(a.sorted.mkString(" "))
    Ok(s"${a.length}")
  }

  /**
    * Create an action called `howToAdd`
    * accept two integers extracted from the URL
    * return a plain text HTTP 200 response containing the HTTP method and URL required to add them together.
    * TIP: Use the reverse route for `add()` to construct the URL.
    */

  def howToAdd(a: Int, b: Int) = Action { result =>

    val call = routes.CalcController.add(a, b)
    Ok(s"${call.method} ${call.url}")
  }

  private def urlDecode(str: String) =
    java.net.URLDecoder.decode(str, "UTF-8")
}
