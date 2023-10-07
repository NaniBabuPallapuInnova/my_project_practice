var sqlite3 = require('sqlite3').verbose()
const DBSOURCE = "expensedb.sqlite"
let db = new sqlite3.Database(DBSOURCE, (err) => {
    if (err) {
        console.error(err.message)
        throw err
    } else {
        console.log('Connected to the SQLite database.')

        // // if table already exist, use this if condition and run it. then stop the server and comment if condition and run the server.
        // if('expense'){
        //     db.run('DROP TABLE expense')
        // } else{
            
        // }

        db.run(`CREATE TABLE expense (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                item text, 
                amount real, 
                category text, 
                place text, 
                spendOn text, 
                createdOn text 
                )`,
            (err) => {
                if (err) {
                    console.log(err);
                } else {
                    var insert = 'INSERT INTO expense (item, amount, category, place, spendOn, createdOn) VALUES (?,?,?,?,?,?)'
                    db.run(insert, ['Pizza', 10, 'Food', 'KFC', '2020-05-26 10:10', '2020-05-26 10:10'])
                    db.run(insert, ['Burger', 9, 'Food', 'Mcdonald', '2020-05-28 11:10', '2020-05-28 11:10'])
                    db.run(insert, ['Fried Chicken', 12, 'KFC', 'Mcdonald', '2020-05-29 09:22', '2020-05-29 09:22'])
                    db.run(insert, ['Biryani', 15, 'Food', 'Chillies Restaurant', '2020-06-06 16:18', '2020-06-06 16:18'])
                    db.run(insert, ['Biscuits', 14, 'Snacks', 'Mall', '2020-06-01 18:14', '2020-05-01 18:14'])
                }
            });
    }
});
module.exports = db