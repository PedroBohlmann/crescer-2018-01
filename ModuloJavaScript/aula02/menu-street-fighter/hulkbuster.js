const fs = require('fs')
const ncp = require('ncp').ncp

function removeDirSync(path) {
    if (fs.existsSync(path)) {
        fs.readdirSync(path).forEach((file, index) => {
            const curPath = path + "/" + file;
            if (fs.lstatSync(curPath).isDirectory()) { // recurse
                removeDirSync(curPath);
            } else { // delete file
                fs.unlinkSync(curPath);
            }
        });
        fs.rmdirSync(path);
    }
};


removeDirSync('./dist')
removeDirSync('./cache')

fs.mkdirSync('./dist')

ncp('./assets', './dist/assets', err => {
    if (err) {
        process.exit(1)
    }
    process.exit(0)
});