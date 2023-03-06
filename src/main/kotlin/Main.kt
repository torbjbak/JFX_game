import io.data2viz.charts.chart.chart
import io.data2viz.charts.chart.mark.plot
import io.data2viz.charts.chart.quantitative
import io.data2viz.charts.viz.newVizContainer
import io.data2viz.geom.Size
import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import models.DamageType
import models.Entity
import models.StackableItem
import models.Weapon
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

private const val width = 300.0
private const val height = 300.0
private val values = listOf(1.0, 2.0, 3.0, 4.0, 5.0)

private const val UNIT = 10.0

fun main() {
//    val entities: Array<Entity> = arrayOf(
//        Weapon("Shortsword", "A short sword, useful for stabbing.", "resources/thumbnails/shortsword.png", 100, 1.3, 10, DamageType.CUT, null, null),
//        Weapon("Stick", "It's a stick, about two feet of wood.", "resources/thumbnails/thumbnails/stick.png", 15, 0.8, 4,  DamageType.BLUNT,null, null),
//        StackableItem("Carrot", "An orange, chewy and somwhat sweet root vegetable.", null, 4, 0.15, 3),
//        Weapon("Frozen staff", "A longstaff magically enchanted with sorcerous cold.", null, 1200, 2.2, 15, DamageType.BLUNT, 12, DamageType.COLD)
//
//    )
//    for(e in entities) {
//       println(e.toString())
//    }

     Application.launch(MyFirstChart::class.java)
}

class MyFirstChart: Application() {

    override fun start(stage: Stage) {
        // Creating the JFX root element, a Pane
        val root = HBox()
        root.padding = Insets(UNIT)
        root.spacing = UNIT

        val grid = GridPane()
        grid.alignment = Pos.CENTER_RIGHT
        grid.hgap = UNIT
        grid.vgap = UNIT
        grid.padding = Insets(UNIT)

        for (param in Weapon::class.primaryConstructor!!.parameters) {
            grid.add(Label(param.name), 0, param.index)
            grid.add(TextField(), 1, param.index)
        }
        grid.add(Button("Add entity"), 1, grid.rowCount)

        val chart = Pane()
        chart.newVizContainer().run {
            size = Size(width, height)
            chart(values) {
                val values = quantitative({domain})
                plot(values, values)
            }
        }

        root.children.addAll(grid, chart)
        stage.apply {
            title = "Tw different things"
            scene = (Scene(root))
            show()
        }
    }
}