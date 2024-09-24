describe('Fundamentals Test', () => {
  beforeEach(() => {
    cy.visit('/fundamentals')
  })

  it('Contains Correct Header Text', () => {
    cy.getDataTest("fundamentals-header").contains(/Testing Fundamentals/i)
    cy.getDataTest("fundamentals-header").should('contain.text', 'Testing Fundamentals')
  })

  it('Accordion works correctly', () => {
    cy.contains(/Your tests will exist in a describe block./i).should('not.be.visible')
    cy.get('[data-test="accordion-item-1"] div[role="button"]').click()
    cy.contains(/Your tests will exist in a describe block./i).should('be.visible')
    cy.get('[data-test="accordion-item-1"] div[role="button"]').click()
    cy.contains(/Your tests will exist in a describe block./i).should('not.be.visible')

  })
})