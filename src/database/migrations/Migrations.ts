import { BaseDatabase } from "../BaseDatabase";
import { PartnerDatabase } from "../PartnerDatabase";
import { partners, partnersAddress, partnersCoverageArea } from "./data";


class Migrations extends BaseDatabase{
    execute = async () => {
        try {
            console.log("Creating tables...");
            await this.createTables();
            console.log("Tables created successfully!");

            console.log("Inserting data...");
            await this.insertData();
            console.log("Data inserted successfully!");

            console.log("Migrations finished successfully!");
        } catch (error) {
            console.log("FAILED! Error in migrations...");
            console.log(error.sqlMessage || error.message);
        } finally {
            console.log("Closing connection...");
            BaseDatabase.connection.destroy();
            console.log("Connection closed!");
        }
    }

    createTables = async () => {
        await BaseDatabase.connection.raw(`
        DROP TABLE IF EXISTS ${PartnerDatabase.TABLE_PARTNERS};

        CREATE TABLE IF NOT EXISTS ${PartnerDatabase.TABLE_PARTNERS} (
            id VARCHAR(255) PRIMARY KEY,
            tradingName VARCHAR(255) NOT NULL,
            ownerName VARCHAR(255) NOT NULL,
            document VARCHAR(255) NOT NULL
        );

        CREATE TABLE IF NOT EXISTS ${PartnerDatabase.TABLE_PARTNERS_COVERAGE_AREA} (
            id VARCHAR(255) PRIMARY KEY,
            partnerId VARCHAR(255) NOT NULL,
            type VARCHAR(255) NOT NULL,
            coordinates VARCHAR(255) NOT NULL,
            FOREIGN KEY (partnerId) REFERENCES ${PartnerDatabase.TABLE_PARTNERS}(id)
        );

        CREATE TABLE IF NOT EXISTS ${PartnerDatabase.TABLE_PARTNERS_ADDRESS} (
            id VARCHAR(255) PRIMARY KEY,
            partnerId VARCHAR(255) NOT NULL,
            type VARCHAR(255) NOT NULL,
            coordinates VARCHAR(255) NOT NULL,
            FOREIGN KEY (partnerId) REFERENCES ${PartnerDatabase.TABLE_PARTNERS}(id)
        );

        `);
    }

    insertData = async () => {
        await BaseDatabase
        .connection(PartnerDatabase.TABLE_PARTNERS)
        .insert(partners)

        await BaseDatabase
        .connection(PartnerDatabase.TABLE_PARTNERS_COVERAGE_AREA)
        .insert(partnersCoverageArea)

        await BaseDatabase
        .connection(PartnerDatabase.TABLE_PARTNERS_ADDRESS)
        .insert(partnersAddress)

    }

}

const migrations = new Migrations();
migrations.execute();
