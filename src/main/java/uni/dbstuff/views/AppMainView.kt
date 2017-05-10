package uni.dbstuff.views

import javafx.beans.property.SimpleIntegerProperty
import javafx.collections.FXCollections
import javafx.geometry.*
import javafx.scene.control.*
import javafx.scene.layout.*
import tornadofx.*
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.Building
import uni.dbstuff.domain.Person
import java.time.LocalDate

class AppMainView : View() {

    override val root = BorderPane()
    val counter = SimpleIntegerProperty()

    private val persons = FXCollections.observableArrayList<Person>(
            Person("A","B","C")

    )

    init {
        title = "Counter"

        with (root) {
            style {

            }
            top{
                menubar {
                    menu("Additional Tables"){
                        menuitem("Roles")
                        menuitem("Building Types")
                        menuitem("Payment Rate")
                    }
                    menu("Calculate Electricity Bill")
                }
            }
            center {
                tabpane {
                    tab("People",GridPane()){
                        tableview<Person> {
                            items = persons
                            column("firstName", Person::firstName)
                            column("middleName", Person::middleName)
                            column("lastName", Person::lastName)
                        }
                    }
                        tab("Areas",TableView<Area>())
                        tab("Buildings", TableView<Building>())
                    }
                }
            }

        }
    }




