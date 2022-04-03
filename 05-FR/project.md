# Auction system

## Introduction

Specification of functional requirements as part of computerisation of the product sale process based on the auction mechanism.

## Business processes

---
<a id="bc1"></a>
### BC1: Auction sale

**Actors:** [Seller](#ac1), [Buyer](#ac2)

**Description:** Business process describing a sale by the auction mechanism.

**Main scenario:**
1. [Seller](#ac1) offers the product at an auction. ([UC1](#uc1))
2. [Buyer](#ac2) offers a bid for the product that is higher than the currently highest bid. ([BR1](#br1))
3. [Buyer](#ac2) wins the auction ([BR2](#br2))
4. [Buyer](#ac2) transfers the amount due to the Seller.
5. [Seller](#ac1) transfers the product to the Buyer.

**Alternative scenarios:** 

2.A. Buyer's bid has been outbid and [Buyer](#ac2) wants to outbid the current highest bid.
* 2.A.1. Continue at step 2.

3.A. Auction time has elapsed and [Buyer](#ac2) has lost the auction. ([BR2](#br2))
* 3.A.1. End of use case.

---

## Actors

<a id="ac1"></a>
### AC1: Seller

A person offering goods at an auction.

<a id="ac2"></a>
### AC2: Buyer

A person intending to purchase a product at an auction..


## User level use cases

### Actors and their goals 

[Seller](#ac1):
* [UC1](#uc1): Offering a product at an auction
* Selling the product at the highest price possible
* Sending the product to the person whose bid was the highest

[Buyer](#ac2):
* [BR1](#br1): Placing a bid for the offered product
* Outbidding the current price
* Claiming the product
* Paying appropriate amount to the seller/auction house

---
<a id="uc1"></a>
### UC1: Offering a product at an auction

**Actors:** [Seller](#ac1)

**Main scenario:**
1. [Seller](#ac1) reports to the system the willingness to offer the product up at an auction.
2. System asks for the product data and initial price.
3. [Seller](#ac1) provides product data and the initial price.
4. System verifies data correctness.
5. System informs that the product has been successfully put up for auction.

**Alternative scenarios:** 

4.A. Incorrect or incomplete product data has been entered.
* 4.A.1. informs about incorrectly entered data.
* 4.A.2. Continue at step 2.

---

<a id="uc2"></a>
### UC2: Transferring the product to the buyer

**Actors:** [Seller](#ac1), [Buyer](#ac2), ...

**Main scenario:**
1. Seller is notified that their product has been bought
2. System verifies whether proper financial operation has been made
3. Buyer's mailing address is sent to the seller via the system
4. The seller ships the product to the buyer
5. Once the product is handled by the shipping company, the buyer gets notified about the sending of the product 

**Alternative scenarios:** 

1.A. The seller decides not to sell the product
* 4.A.1. The auction is ceased
* 4.A.2. Every person who's bid so far is notified about the termination of the auction
* 4.A.3. This specific auction is no longer listed on the webpage/is marked as unavailable

2.B. The product is damaged during delivery
* 4.B.1. The buyer notifies the seller that the product has been damaged during shipment and requests compensation
* 4.B.2. The seller transfers suitable amount of money (including the possiblity of a full refund) to the seller to make up for the damage
* 4.B.3. If the buyer is dissatisfied with the amount -> return to 4.B.2


---
UC3: The buyer leaves a review

Actors: Buyer

Main scenario:
1. The buyer liked the product
2. The buyer leaves a positive review on the seller's profile

Alternative scenario:
1. The buyer did not like the product
2. The buyer leaves a negative review on the seller's profile
---

## Business objects (also known as domain or IT objects)

### BO1: Auction

The auction is a form of concluding a sale and purchase transaction in which the Seller specifies the starting bid of the product, while the Buyers may offer their own purchase offer, each time proposing a bid higher than the currently offered bid. The auction ends after a specified period of time. If at least one purchase offer has been submitted, the product is purchased by the Buyer who offered the highest bid. 

### BO2: Product

A physical or digital item to be auctioned.

## Business rules

<a id="br1"></a>
### BR1: Bidding at auction

Bidding at auction requires submitting an amount higher than current by a minimum of EUR 1.00

<a id="br2"></a>
### BR2: Winning an auction

Auction is won by [Buyer](#ac2) who submitted the highest bid before the end of the auction (time expires).

### BR3: Paying for the product
Auction is won [BR2] by the buyer [Buyer](#ac2). They pay the appropriate amount to the seller [Seller](#ac1) who then sends the product to the buyer.

## CRUDL Matrix


| Use case                                  | Auction | Product | Review |
| ----------------------------------------- | ------- | ------- | ---    |
| UC1: Offering a product at an auction     |    C    |    C    | ...    |
| BR1: Bidding at an auction                |    R    |   R,U   | ...    |
| BR2: Winning an auction                   |   U     |    U    | ...    |
| BR3: Paying for the product               |   D     |   R     | ...    |
| UC2: Transferring the product to the buyer|   D     |   D     | ...    |
| UC3: The buyer leaves a review            |   D     |    D    |  C     |



