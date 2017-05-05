package uni.dbstuff.domain;

import java.sql.Date
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "electricity_rate")
class ElectricityRate: BaseModel(){

    var begin: Date? = null

    var finish: Date? = null

    var rate: Double? = null

}
