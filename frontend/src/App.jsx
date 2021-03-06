import './App.css'
import React from 'react'

import { Routes, Route } from 'react-router-dom'

import LenderDashboard from './pages/lender'
import BorrowerDashboard from './pages/borrower'
import RequestsDashboard from './pages/requests'
import TransactionsDashboard from './pages/transactions'
import HomeScreen from './pages/home'
import AddBook from './pages/addBook'
import ConfirmBook from './pages/confirmBook'
import LoginPage from './pages/loginPage'
import SignUpPage from './pages/signUpPage'
import BookDetails from './pages/bookDetail'
import UserProfile from './pages/userProfile'
import AdminPage from './pages/admin'
import AdminLogin from './pages/adminLogin'

export default function App() {
  return (
    <>
      <Routes>
        <Route exact element={<HomeScreen />} path="/" />
        <Route element={<LoginPage />} path="/login" />
        <Route element={<SignUpPage />} path="/register" />
        <Route element={<LenderDashboard />} path="/lender" />
        <Route element={<BorrowerDashboard />} path="/borrower" />
        <Route element={<RequestsDashboard />} path="/requests" />
        <Route element={<AddBook />} path="/lender/addBook" />
        <Route element={<ConfirmBook />} path="/lender/confirmBook" />
        <Route element={<TransactionsDashboard />} path="/transactions" />
        <Route element={<BookDetails />} path="/borrower/book/:bookID" />
        <Route element={<UserProfile/>} path="/profile" />
        <Route element={<AdminPage/>} path="/admin" />
        <Route element={<AdminLogin/>} path="/adminLogin" />
      </Routes>
    </>
  )
}
