package api.example


import groovy.json.JsonBuilder
import groovy.sql.GroovyRowResult
import groovy.sql.Sql

import java.text.SimpleDateFormat

def laden() {
  /*
   * Zuerst sollten die Request-Paramter ausgelesen werden
   * Anhand dieser entscheiden wird, welche Bestellungen wir aus der Datenbank abfragen
   */


  def url= "jdbc:mariadb://db:3306/cms"
  def username = "cms"
  def password = "cms"
  def driver = 'org.mariadb.jdbc.Driver'

  def sql = Sql.newInstance(url, username, password, driver)

  String id = request.getParameter("id")
  String kunde = request.getParameter("kunde")
  String abDatum = request.getParameter("abDatum")
  // Wird z.B. im Format yyyy-MM-dd an Server gesendet, Alle bestellungen ab dem Datum


  if (id != null) {
    // Wenn eine ID an den Server Gesendet wurde, will man nur die eine Bestellung mit dieser ID laden
    GroovyRowResult bestellungRow = sql.firstRow("""
    SELECT * FROM bxc_bestellung b
    WHERE b.ID = ?
    """, [id /* Parameter der das ? ersetzt */])

    // aus der Datenbank-Row ein JSON-String erzeugen und an den Webclient senden
    print(new JsonBuilder(bestellungRow).toPrettyString())

  } else {
    // ID wurde nicht übergeben, das heißt es sollen Bestellungen gefiltert werden

    Date datum = null
    if (abDatum != null) {
      /*
        Der Request-Parameter abDatum ist ein String
        Um damit arbeiten zu können müssen wir diesen in ein Date-Object parsen
       */
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
      datum = sdf.parse(abDatum)
    }


    /* hier ein etwas anderes Beispiel um ein SQL-Statement auszuführen.
     * Statt Platzhalter mit '?' zu kennzeichnen kann man sie in den String direkt mit
     * '$<variable>' einfügen
     */
    GroovyRowResult[] bestellungRows = sql.rows("""
    SELECT * FROM bxc_bestellung b
    WHERE ($kunde IS NULL OR b.Kunde = $kunde)
    AND ($datum IS NULL OR b.Datum >= $datum)
    """)

    // aus den Datenbank-Rows ein JSON-String erzeugen und an den Webclient senden
    print(new JsonBuilder(bestellungRows).toPrettyString())

    sql.close()
  }
}
