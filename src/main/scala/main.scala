import java.sql._

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit = {
  val db = new DBConnection("c##browntj16", "Foofighters95")
  db.executeQuery("Select * from sys.inventory")
}
